package com.demon.design.test.ioutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @desc
 * @fileName TmpFileTest.java
 * @date 2022/10/29/0029 10:03
 * @author Dongmo.Wu
 */
public class TmpFileTest {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.io.tmpdir"));
		/*Map map = new HashMap();
		map.put("key1", "val1");
		String jsonStr = JsonHelper.toJson(map);

		TmpFileTest tmpFileTest = new TmpFileTest();
		tmpFileTest.generateTemJsonFile(jsonStr);*/
		int[] arr1 = {1,2,3};
		int[] arr1Copy = Arrays.copyOf(arr1, arr1.length);

		String col = "\"hello\"";
		char[] arr = col.toCharArray();

		for (char c : arr) {
			switch (c) {
				case '[':
				case ']':
				case '`':
				case '\"':
				case '\'':
					break;
				default:
					System.out.println( c );
			}
		}

	}

	private String generateTemJsonFile(String jobJson) {
		// 根据json写入到临时本地文件
		String tmpFilePath = StringUtils.join(System.getProperty("java.io.tmpdir"), File.separator, "jobTmp-",
				UUID.randomUUID().toString(), ".json");
		write(jobJson, new File(tmpFilePath));
		return tmpFilePath;
	}

	public static void write(final CharSequence data, final File file) {
		Validate.notNull(file);
		Validate.notNull(data);

		try {
			BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8);

			try {
				writer.append(data);
			} catch (Throwable var6) {
				if (writer != null) {
					try {
						writer.close();
					} catch (Throwable var5) {
						var6.addSuppressed(var5);
					}
				}

				throw var6;
			}

			if (writer != null) {
				writer.close();
			}

		} catch (IOException var7) {
			throw new RuntimeException(var7);
		}
	}
}
