package com.demon.io.service.impl;

import com.demon.io.mapper.TestMapper;
import com.demon.io.model.TczrkJbxx;
import com.demon.io.service.TestMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @desc
 * @fileName TestMapperServiceImpl.java
 * @date 2023/8/22/0022 13:55
 * @author Dongmo.Wu
 */
@Service
public class TestMapperServiceImpl implements TestMapperService {
	@Resource
	private TestMapper testMapper;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public void batchInsert(String sql) {
		testMapper.insertBigDataToGauss(sql);
	}
}
