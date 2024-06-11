package com.demon.io.jsonpath;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        // 给定的 JSONPath 表达式和相应的值
        String[] jsonPaths = {
            "$.store.book[].author",
            "$.store.book[].title",
            "$.store.book[].price"
        };
        String[] values = {
            "xiaoming",
            "title1",
            "1.27"
        };

        // 构建请求体
        Map<String, Object> requestBodyMap = new HashMap<>();
        List<Map<String, Object>> bookList = new ArrayList<>();
        Map<String, Object> bookMap = new HashMap<>();

        // 添加书籍信息到 bookMap 中
        for (int i = 0; i < jsonPaths.length; i++) {
            String key = jsonPaths[i].substring(jsonPaths[i].lastIndexOf(".") + 1);
            bookMap.put(key, values[i]);
        }
        bookList.add(bookMap);

        // 添加书籍列表到 requestBodyMap 中
        Map<String, Object> storeMap = new HashMap<>();
        storeMap.put("book", bookList);
        requestBodyMap.put("store", storeMap);

        // 将请求体 Map 转换为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String requestBody = objectMapper.writeValueAsString(requestBodyMap);
            System.out.println(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}