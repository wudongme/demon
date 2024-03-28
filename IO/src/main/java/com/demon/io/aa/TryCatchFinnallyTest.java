package com.demon.io.aa;

/**
 *
 * @desc
 * @fileName TryCatchFinnallyTest.java
 * @date 2023/9/15 14:47
 * @author Dongmo.Wu
 */
public class TryCatchFinnallyTest {
	public static void main(String[] args) {
		test1();
	}

	private static int test1() {
		try {
			try {
				System.out.println("first");
				int i = 1/0;
			} finally {
				System.out.println("执行finally");
				return -1;
			}
		} catch (Exception exception) {
			System.out.println("exception执行");
			return 0;
		}
	}


}
