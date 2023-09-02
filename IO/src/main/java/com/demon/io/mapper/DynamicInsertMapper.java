package com.demon.io.mapper;

import com.demon.io.model.PrepareInsertModel;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @desc
 * @fileName DynamicInsertMapper.java
 * @date 2023/9/1/0001 23:06
 * @author Dongmo.Wu
 */
public interface DynamicInsertMapper {
	void universalPrepareBatchInsert(@Param("model") PrepareInsertModel model);
}
