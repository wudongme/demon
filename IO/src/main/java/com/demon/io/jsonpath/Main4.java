package com.demon.io.jsonpath;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {
        // 给定的 JSONPath 表达式和相应的值
        String[] jsonPathArray = {
            "$.store.book.[].author",
            "$.store.book.[].title",
            "$.store.book.[].price"
        };
        String[] values = {
            "xiaoming",
            "title1",
            "1.27"
        };



        // 解析 JSONPath 表达式并构建请求体结构
		Object res = null;
        for (int i = 0; i < jsonPathArray.length; i++) {
			String jsonPath = jsonPathArray[i];
			String[] split = jsonPath.split("\\.");
			if (split.length == 0) {
				throw new RuntimeException("请求体字段格式有误");
			}
			Object requestBody = null;
			String root = split[0];
			if ("$".equals(root)) {
				requestBody = new ArrayList<Map<String, Object>>();
			} else if ("$[]".equals(root)) {
				requestBody = new HashMap<String, Object>();
			} else {
				throw new RuntimeException("格式有误");
			}

			if (split.length == 1) {
				System.out.println("只解析了一层");
				throw new RuntimeException("格式有误");
			}
			Object cur = res;
			for (int j = 1; j < split.length; j++) {
				if ("[]".equals(split[j])) {
					// 第二层不能是数组，因为是数组的话缺少
					if (j == 1) {
						System.out.println("第二层不能是数组");
						throw new RuntimeException("第二层不能是数组");
					}
					if (cur instanceof ArrayList) {
						throw new RuntimeException("不支持连续两层数组的数据结构");
					} else if (cur instanceof HashMap) {

					}
				}
			}
		}

        // 将请求体 Map 转换为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        /*try {
            String requestBody = objectMapper.writeValueAsString(requestBodyMap);
            System.out.println("Request Body: " + requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}

