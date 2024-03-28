package com.demon.io.service.cdc;

import io.debezium.data.Envelope;
import io.debezium.embedded.Connect;
import io.debezium.engine.DebeziumEngine;
import io.debezium.engine.RecordChangeEvent;
import io.debezium.engine.format.ChangeEventFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * @desc
 * @fileName DebeziumTest.java
 * @date 2024/2/27 12:49
 * @author Dongmo.Wu
 */
@Slf4j
public class DebeziumTest {
	private void createFile(String dir) {
		File file = FileUtils.getFile(dir);
		file.mkdirs();
	}
	static final String offsetDir = "test/offset";
	static final String historyDir = "test/history";
	public DebeziumEngine<RecordChangeEvent<SourceRecord>> testDebezium() {
		createFile(offsetDir);
		createFile(historyDir);

		Properties properties = new Properties();
		properties.setProperty("connector.class", "io.debezium.connector.mysql.MySqlConnector");
		properties.setProperty("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore");
		properties.setProperty("offset.flush.interval.ms", "0");
		properties.setProperty("database.history", "io.debezium.relational.history.FileDatabaseHistory");
		properties.setProperty("schema_only", "true");
		properties.setProperty("converter.schemas.enable", "false");
		properties.setProperty("database.serverTimezone", "UTC");
		properties.setProperty("snapshot.locking.mode", "none");
		properties.setProperty("include.schema.changes", "false");
		properties.setProperty("snapshot.mode", "schema_only");
		properties.setProperty("max.batch.size", "3000");
		properties.setProperty("database.history.skip.unparseable.ddl", "true");
		properties.setProperty("database.history.store.only.monitored.tables.ddl", "true");
		properties.setProperty("include.query", "false");
		//todo
		properties.setProperty("database.whitelist", "dis_realtime");

		properties.setProperty("database.hostname", "172.16.1.96");
		properties.setProperty("database.port", "3306");
		properties.setProperty("database.url", "172.16.1.96:3306/dis_realtime");

		properties.setProperty("database.user", "root");
		properties.setProperty("database.password", "123456");

		properties.setProperty("database.server.id", "20271237");
		// todo 改动的地方
		properties.setProperty("database.server.name", "C-20271237");
		properties.setProperty("topic.prefix", "C-20271237");
		// 时区
		properties.setProperty("database.serverTimezone", "UTC");
		// 1. 使用database.whitelist，只设置数据库（会通知全库的CDC信息）
		// 2. 使用table.whitelist，设置库名和表名（会通知单个库的单个表的CDC信息）

		// oracle特有
		// todo
		properties.setProperty("table.whitelist", "dis_realtime.dbz_2_0");

		String offsetPath = StringUtils.join(offsetDir, ".dat");
		String pathFileName = StringUtils.join(historyDir, ".dat");

		// todo 新增
		properties.setProperty("schema.history.internal.kafka.topic", "topic111");
		//properties.setProperty("schema.history.internal.kafka.bootstrap.servers", "localhost:9092");
		// todo 尝试自己添加
		properties.setProperty("schema.history", "io.debezium.relational.history.FileDatabaseHistory");
		properties.setProperty("schema.history.file.filename", pathFileName);

		properties.setProperty("name", "name-20271237");
		properties.setProperty("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore");

		properties.setProperty("offset.storage.file.filename", offsetPath);
		properties.setProperty("database.history", "io.debezium.relational.history.FileDatabaseHistory");
		properties.setProperty("database.history.file.filename", pathFileName);

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
			}
		}).notifying(this::handlePayload).build();
		return debeziumEngine;
	}

	public void handlePayload(List<RecordChangeEvent<SourceRecord>> recordChangeEvents,
			DebeziumEngine.RecordCommitter<RecordChangeEvent<SourceRecord>> recordCommitter){
		for (RecordChangeEvent<SourceRecord> r : recordChangeEvents) {
			SourceRecord sourceRecord = r.record();
			Struct payload = (Struct) sourceRecord.value();
			if (Objects.isNull(payload)) {
				continue;
			}
			Envelope.Operation operation = getOperation(payload);


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
