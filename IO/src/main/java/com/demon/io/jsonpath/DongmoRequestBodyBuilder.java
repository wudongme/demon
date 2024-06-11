package com.demon.io.jsonpath;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DongmoRequestBodyBuilder {
    public static Map<String, Object> buildRequestBody(List<Map<String, Object>> resultList) {
        Map<String, Object> requestBody = new HashMap<>();

		Data data = new Data();
		for (Map<String, Object> map : resultList) {
            parseMap(requestBody, map, data);
        }
		for (Map<String, Object> map : resultList) {
			writeToArray(map, data);
		}

        return requestBody;
    }

	private static void writeToArray(Map<String, Object> map, Data data) {
		Map<String, Object> element = new HashMap<>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String nameValue = Data.map.get(entry.getKey());
			if (StringUtils.isNotBlank(nameValue)) {
				element.put(nameValue, entry.getValue());
			}
		}
		data.dataList.add(element);
	}

	static class Data{
		public List<Map<String, Object>> dataList;
		public static Map<String, String> map = new HashMap<>();
		static {
			map.put("phoneNumbers[].type", "type");
			map.put("phoneNumbers[].number", "number");
		}
	}

    private static void parseMap(Map<String, Object> requestBody, Map<String, Object> map, Data data) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String[] partArray = key.split("\\.");

			// 处理数组外层的键值对
			// 处理数组
			Map<String, Object> currentMap = requestBody;
			for (int i = 0; i < partArray.length; i++) {
				String part = partArray[i];
				if (StringUtils.isBlank(part)) {
					System.out.println("错误key:" + key);
					throw new RuntimeException("字段为空");
				}
				int indexOfArray = part.indexOf("[]");
				if (indexOfArray > -1) {
					part = part.substring(0, indexOfArray);
					Object o = currentMap.get(part);
					if (o == null) {
						List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
						currentMap.put(part, list);
						data.dataList =  list;
					} /*else {
						if (!(o instanceof ArrayList)) {
							System.out.println("数组和Map冲突");
							throw new RuntimeException("配置错误");
						}
					}*/
				} else {
					Object o = currentMap.get(part);
					// 最后一个key
					if (i == partArray.length - 1) {
						currentMap.put(part, value);
					} else {
						if (o == null) {
							Map<String, Object> nextMap = new HashMap<>();
							currentMap.put(part, nextMap);
							currentMap = nextMap;
						} else {
							currentMap = (HashMap<String, Object>) o;
						}
					}
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
        resultMap.put("phoneNumbers[].type", "phone1");
        resultMap.put("phoneNumbers[].number", "0123-4567-8");
		resultMap.put("name", "xiaoming");
		resultMap.put("address.streetAddress", "naist street");
		resultMap.put("address.city", "nara");
        resultList.add(resultMap);

        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("phoneNumbers[].type", "phone2");
        resultMap2.put("phoneNumbers[].number", "0123-4567-8");
		resultMap.put("name", "xiaoming2");
		resultMap.put("address.streetAddress", "naist street2");
		resultMap.put("address.city", "nara2");
        resultList.add(resultMap2);

        Map<String, Object> requestBody = buildRequestBody(resultList);
        System.out.println(JSONObject.toJSON(requestBody));
    }
}