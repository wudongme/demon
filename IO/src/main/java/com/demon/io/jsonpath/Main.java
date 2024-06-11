package com.demon.io.jsonpath;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 给定的 JSONPath 表达式和相应的值
        String[] jsonPaths = {
            "$.store.book[1].author",
            "$.store.book[1].title",
            "$.store.book[1].price"
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

            // 创建嵌套的 Map 结构，根据 JSONPath 表达式设置相应的值
            Map<String, Object> nestedMap = new HashMap<>();
            nestedMap.put(key, values[i]);

            // 设置嵌套的 Map 结构到请求体 Map 中
            setNestedMap(requestBodyMap, jsonPaths[i], nestedMap);
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

    // 设置嵌套的 Map 结构到请求体 Map 中
    private static void setNestedMap(Map<String, Object> requestBodyMap, String jsonPath, Map<String, Object> nestedMap) {
        String[] keys = jsonPath.substring(2).split("\\."); // 去掉开头的 "$." 并按照 . 分割键
        Map<String, Object> currentMap = requestBodyMap;
        for (int i = 0; i < keys.length - 1; i++) {
            if (!currentMap.containsKey(keys[i])) {
                currentMap.put(keys[i], new HashMap<String, Object>());
            }
            currentMap = (Map<String, Object>) currentMap.get(keys[i]);
        }
        currentMap.putAll(nestedMap);
    }
}
