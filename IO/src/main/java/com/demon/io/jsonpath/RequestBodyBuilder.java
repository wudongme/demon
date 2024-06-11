package com.demon.io.jsonpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestBodyBuilder {
    public static Map<String, Object> buildRequestBody(List<Map<String, Object>> resultList) {
        Map<String, Object> requestBody = new HashMap<>();

        for (Map<String, Object> map : resultList) {
            parseMap(requestBody, map, "");
        }

        return requestBody;
    }

    private static void parseMap(Map<String, Object> requestBody, Map<String, Object> map, String prefix) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String[] parts = key.split("\\.");

            if (parts.length >= 2) {
                String firstPart = parts[0];
                String remainingParts = key.substring(firstPart.length() + 1);

                if (firstPart.equals("$")) {
                    parseValue(requestBody, remainingParts, value, prefix);
                } else {
                    Map<String, Object> nestedMap = (Map<String, Object>) requestBody.getOrDefault(firstPart, new HashMap<>());
                    requestBody.put(firstPart, nestedMap);
                    parseMap(nestedMap, map, prefix + firstPart + ".");
                }
            }
        }
    }

    private static void parseValue(Map<String, Object> requestBody, String key, Object value, String prefix) {
        String[] indexes = key.split("\\]\\[");
        Object currentValue = requestBody;

        for (int i = 0; i < indexes.length; i++) {
            String index = indexes[i];

            if (i == indexes.length - 1) {
                if (index.startsWith("[].")) {
                    String propertyName = index.substring(3);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) currentValue;

                    if (list.isEmpty()) {
                        Map<String, Object> newMap = new HashMap<>();
                        newMap.put(propertyName, value);
                        list.add(newMap);
                    } else {
                        for (Map<String, Object> existingMap : list) {
                            existingMap.put(propertyName, value);
                        }
                    }
                } else {
                    ((Map<String, Object>) currentValue).put(index, value);
                }
            } else {
                String currentIndex = index.startsWith("[].") ? "" : index;
                currentValue = getOrCreateValue(currentValue, currentIndex);
            }
        }
    }

    private static Object getOrCreateValue(Object currentValue, String index) {
        if (currentValue instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) currentValue;
            return map.computeIfAbsent(index, k -> new ArrayList<>());
        } else if (currentValue instanceof List) {
            List<Object> list = (List<Object>) currentValue;
            int indexValue = index.isEmpty() ? 0 : Integer.parseInt(index);

            while (list.size() <= indexValue) {
                list.add(new HashMap<>());
            }

            return list.get(indexValue);
        }

        return null;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("$.phoneNumbers[1].type", "phone1");
        resultMap.put("$.phoneNumbers[1].number", "0123-4567-8");
        resultList.add(resultMap);

        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("$.phoneNumbers[2].type", "phone2");
        resultMap2.put("$.phoneNumbers[2].number", "0123-4567-8");
        resultList.add(resultMap2);

        Map<String, Object> requestBody = buildRequestBody(resultList);
        System.out.println(requestBody);
    }
}