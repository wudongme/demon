package com.demon.io.service.cdc;

import io.debezium.config.Configuration;
import io.debezium.data.Envelope;
import io.debezium.embedded.Connect;
import io.debezium.engine.DebeziumEngine;
import io.debezium.engine.RecordChangeEvent;
import io.debezium.engine.format.ChangeEventFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 *
 * @desc
 * @fileName DebeziumTest.java
 * @date 2024/2/27 12:49
 * @author Dongmo.Wu
 */
@Slf4j
public class PostgresqlDebeziumTest {
	public static void main(String[] args) {
		PostgresqlDebeziumTest postgresqlDebeziumTest = new PostgresqlDebeziumTest();
		DebeziumEngine<RecordChangeEvent<SourceRecord>> engine = postgresqlDebeziumTest.testDebezium();
		new Thread(engine).start();
	}
	private void createFile(String dir) {
		File file = FileUtils.getFile(dir);
		if (file.exists()) {
			System.out.println("文件夹已存在");
		}
		file.mkdirs();
	}
	static final String offsetDir = "pgtest/offset";
	static final String historyDir = "pgztest/history";
	public DebeziumEngine<RecordChangeEvent<SourceRecord>> testDebezium() {
		createFile(offsetDir);
		createFile(historyDir);

		Properties properties = new Properties();

		//properties.setProperty("database.whitelist", "dis_realtime");

		properties.setProperty("database.hostname", "localhost");
		properties.setProperty("database.port", "5432");
		properties.setProperty("database.url", "jdbc:postgresql://localhost:5432/postgres?currentSchema=debeziumtest?TimeZone=Asia/Shanghai");

		properties.setProperty("database.user", "dongmo");
		properties.setProperty("database.password", "123456");

		properties.setProperty("database.server.id", "20271237");
		// todo 改动的地方
		properties.setProperty("database.server.name", "C-20271237");
		properties.setProperty("topic.prefix", "C-20271237");
		// 时区
		//properties.setProperty("database.serverTimezone", "UTC");
		//properties.setProperty("database.serverTimezone", "Asia/Shanghai");
		// 1. 使用database.whitelist，只设置数据库（会通知全库的CDC信息）
		// 2. 使用table.whitelist，设置库名和表名（会通知单个库的单个表的CDC信息）

		// oracle特有
		// todo
		//properties.setProperty("table.whitelist", "dis_realtime.dbz_2_0");

		String offsetPath = StringUtils.join(offsetDir, ".dat");
		String pathFileName = StringUtils.join(historyDir, ".dat");

		// todo 新增
		properties.setProperty("schema.history.internal.kafka.topic", "topic111");
		// todo 尝试自己添加
		properties.setProperty("schema.history", "io.debezium.relational.history.FileDatabaseHistory");
		properties.setProperty("schema.history.file.filename", pathFileName);

		properties.setProperty("name", "name-20271237");
		properties.setProperty("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore");

		properties.setProperty("offset.storage.file.filename", offsetPath);
		properties.setProperty("database.history", "io.debezium.relational.history.FileDatabaseHistory");
		properties.setProperty("database.history.file.filename", pathFileName);

		// PostgresqlBuilder复制
		properties.setProperty("connector.class", "io.debezium.connector.postgresql.PostgresConnector");
		// initial
		properties.setProperty("snapshot.mode", "initial");
		properties.setProperty("database.history", "io.debezium.relational.history.FileDatabaseHistory");
		properties.setProperty("offset.flush.interval.ms", "2000");
		properties.setProperty("include.schema.changes", "false");

		properties.setProperty("max.batch.size", "3000");
		properties.setProperty("database.dbname", "postgres");
		properties.setProperty("snapshot.select.statement.overrides",
				"snapshot.select.statement.overrides." + "debeziumtest.timestamp_debezium");
		//properties.setProperty("table.include.list", "debeziumtest.timestamp_debezium");


		properties.setProperty("plugin.name", "pgoutput");
		properties.setProperty("slot.name", "risk_logical_slot_81_72");
		properties.setProperty("initial.only", "false");
		properties.setProperty("snapshot.custom.class", "io.debezium.connector.postgresql.snapshot.NeverSnapshotter");

		DebeziumEngine<RecordChangeEvent<SourceRecord>> debeziumEngine = DebeziumEngine.create(
				ChangeEventFormat.of(Connect.class)).using(properties).using(new DebeziumEngine.ConnectorCallback() {
			@Override
			public void connectorStarted() {
				System.out.println("connectorStarted");
			}

			@Override
			public void connectorStopped() {
				System.out.println("connectorStopped");
			}

			@Override
			public void taskStarted() {
				System.out.println("task started");
			}

			@Override
			public void taskStopped() {
				System.out.println("taskStopped");
			}
		}).using((success, message, error) -> {
			error.printStackTrace();
			if (!success) {
				System.out.println("start error");
			} else {
				System.out.println("==============start success");
			}
		}).notifying(this::handlePayload).build();
		return debeziumEngine;
	}

	public void handlePayload(List<RecordChangeEvent<SourceRecord>> recordChangeEvents,
			DebeziumEngine.RecordCommitter<RecordChangeEvent<SourceRecord>> recordCommitter){
		String format = "收到%s条数据";
		System.out.println(String.format(format, recordChangeEvents.size()));
		for (RecordChangeEvent<SourceRecord> r : recordChangeEvents) {
			SourceRecord sourceRecord = r.record();
			Struct payload = (Struct) sourceRecord.value();
			if (Objects.isNull(payload)) {
				continue;
			}
			Envelope.Operation operation = getOperation(payload);
			String opCode = operation.code();
			if (Envelope.Operation.CREATE.code().equals(opCode)) {
				Field source = payload.schema().schema().fields().stream().filter(f -> Objects.equals("after", f.name()))
						.findFirst().orElse(null);
				Struct afterValue = (Struct) payload.get(source);
				List<Field> fields = afterValue.schema().fields();
				Map<String, Object> values = fields.stream().map(Field::name)
						.filter(value -> org.apache.commons.lang.StringUtils.isNotBlank(value) && afterValue.get(value) != null)
						.map(value -> Pair.of(value, afterValue.get(value)))
						.collect(Collectors.toMap(Pair::getKey, Pair::getValue));
				Long l = 1719418677341756L;
				System.out.println("map:" + values);
				for (Map.Entry<String, Object> entry : values.entrySet()) {
					String key = entry.getKey();
					if ("create_time".equals(key)) {
						Object value = entry.getValue();
						if (value instanceof Long) {
							long time = (Long) value;
							System.out.println(DateFormatUtils.format(new Date(time / 1000), "yyyy-MM-dd HH:mm:ss"));
						} else {
							System.out.println("时间类型为：" + entry.getValue().getClass() + ";值= "+ entry.getValue());
						}

					}
				}
				System.out.println(payload);
			}
			try {
				recordCommitter.markBatchFinished();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static Envelope.Operation getOperation(Struct payload) {
		try {
			return Envelope.Operation.forCode(payload.getString("op"));
		} catch (Exception e) {
			//log.debug(e.getMessage());
			System.out.println("ssss");
			return null;
		}
	}
}