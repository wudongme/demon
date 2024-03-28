package com.demon.io.service.impl;

import com.demon.io.service.cdc.CdcService;
import com.demon.io.service.cdc.DebeziumTest;
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
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * @desc
 * @fileName CdcServiceImpl.java
 * @date 2024/2/26 16:12
 * @author Dongmo.Wu
 */
@Service
@Slf4j
public class CdcServiceImpl implements CdcService {


	@Override
	public Object test1() {
		DebeziumTest debeziumTest = new DebeziumTest();
		DebeziumEngine<RecordChangeEvent<SourceRecord>> recordChangeEventDebeziumEngine = debeziumTest.testDebezium();
		new Thread(recordChangeEventDebeziumEngine).start();
		return null;
	}

}
