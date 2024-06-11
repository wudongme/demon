package com.demon.io.mapper;

import com.demon.io.model.TCzrkJbxx_back;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @desc
 * @fileName TestMapper.java
 * @date 2023/4/19/0019 23:29
 * @author Dongmo.Wu
 */
public interface TestMapper {
	List<Map<String, Object>> test1();
	void insertGeneralMap(@Param("tabName") String tabName, @Param("colStr") String colStr, @Param("colList") List<String> colList, @Param("mapList") List<Map<String, Object>> mapList);

	void insertBigDataToGauss(@Param("sql") String sql);

	void truncate(@Param("sql") String sql);

	void concatTest(@Param("str") String test_str);

}
