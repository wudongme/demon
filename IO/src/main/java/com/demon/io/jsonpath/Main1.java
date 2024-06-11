package com.demon.io.jsonpath;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
        // 给定的 JSONPath 表达式和相应的值
        String[] jsonPaths = {
            "$.store.book[*].author",
            "$.store.book[*].title",
            "$.store.book[*].price"
        };
        String[] values = {
            "xiaoming",
            "title1",
            "1.27"
        };

        // 构建请求体
        Map<String, Object> requestBodyMap = new HashMap<>();
        for (int i = 0; i < jsonPaths.length; i++) {
            // 解析 JSONPath 表达式以获取键
            String key = jsonPaths[i].substring(jsonPaths[i].lastIndexOf(".") + 1);

            // 将键和值添加到请求体 Map 中
            requestBodyMap.put(key, values[i]);
        }

        // 将请求体 Map 转换为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String requestBody = objectMapper.writeValueAsString(requestBodyMap);
            System.out.println("Request Body: " + requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}