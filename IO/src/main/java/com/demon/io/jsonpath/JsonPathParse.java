package com.demon.io.jsonpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @desc
 * @fileName JsonPathParse.java
 * @date 2024/4/3 17:31
 * @author Dongmo.Wu
 */
public class JsonPathParse {
	public static void main(String[] args) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("$.phoneNumbers[].type", "phone1");
		resultMap.put("$.phoneNumbers[].number", "0123-4567-8");
		resultList.add(resultMap);

		Map<String, Object> resultMap2 = new HashMap<>();
		resultMap2.put("$.phoneNumbers[].type", "phone2");
		resultMap2.put("$.phoneNumbers[].number", "0123-4567-8");
		resultList.add(resultMap2);
		// 遍历resultList，然后遍历resultList里面的每一个Map，解析每一个key，形成请求体，请求体可能是数组，有可能是单个对象（里面可能有数组）
		// 通过'.'进行分割
		// $代表最外面一层是Map<String, Object>;$[]代表最外一层是List<Map<String, Object>>
		// 示例： resultMap2.put("$.phoneNumbers[].type", "phone2");，代表最外面一层是"phoneNumbers":[{"type":"phone2"}]
		// 示例： resultMap2.put("$.phoneNumbers[].number", "0123-4567-8")，代表最外面一层是"phoneNumbers":[{"number":"0123-4567-8"}]
		// 一般是先判断phoneNumbers这个对应的数组，存不存在，存在的话，则直接添加，不存在则创建
		// 请帮我通过我的描述，将resultMap形成最终的请求体


	}
}
