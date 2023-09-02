package com.demon.io.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @desc
 * @fileName TestMapperService.java
 * @date 2023/8/22/0022 13:55
 * @author Dongmo.Wu
 */
public interface TestMapperService {
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	void batchInsert(String sql);
}
