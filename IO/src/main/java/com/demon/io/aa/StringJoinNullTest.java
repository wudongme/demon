package com.demon.io.aa;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @desc
 * @fileName StringJoinNullTest.java
 * @date 2023/10/17 16:26
 * @author Dongmo.Wu
 */
public class StringJoinNullTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hll");
		list.add("ss");
		list.add(null);

		String tmpdirPath = System.getProperty("java.io.tmpdir");
		System.out.println(tmpdirPath);
		System.out.println(StringUtils.join(list, ","));
	}
}
