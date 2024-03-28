package com.demon.io.localdatetimetest;

import java.time.LocalDateTime;

/**
 *
 * @desc
 * @fileName LocalDateTimeBeforeTest.java
 * @date 2024/3/8 11:40
 * @author Dongmo.Wu
 */
public class LocalDateTimeBeforeTest {
	public static void main(String[] args) {
		/*LocalDateTime deleteTime = LocalDateTime.now();
		LocalDateTime createTime = LocalDateTime.of(2024, 3, 1, 0,0,0);
		System.out.println(createTime.isBefore(deleteTime));
		System.out.println(deleteTime.isBefore(createTime));

		String s1 = "11";
		String s2 = s1;

		s1 = "33";
		System.out.println(s1);
		System.out.println(s2);*/
		out:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 3) {
					break out;
				}
			}
			if (i == 1) {
				System.out.println("。。。");
			}
		}
	}
}
