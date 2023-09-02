package com.demon.design.test.ioutil;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 *
 * @desc
 * @fileName JsonHelper.java
 * @date 2022/10/29/0029 10:15
 * @author Dongmo.Wu
 */
public class JsonHelper {
	public static String toJson(Map<String, Object> map) {
		return JSON.toJSONString(map);
	}
}
