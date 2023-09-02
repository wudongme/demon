package com.demon.io.service.impl;

import com.demon.io.mapper.DynamicInsertMapper;
import com.demon.io.model.PrepareInsertModel;
import com.demon.io.service.DynamicInsertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @desc
 * @fileName DynamicInsertServiceImpl.java
 * @date 2023/9/1/0001 23:10
 * @author Dongmo.Wu
 */
@Service
@Slf4j
public class DynamicInsertServiceImpl implements DynamicInsertService {
	@Resource
	private DynamicInsertMapper dynamicInsertMapper;
	@Override
	public void dynamicInsert(PrepareInsertModel model) {
			dynamicInsertMapper.universalPrepareBatchInsert(model);
	}
}
