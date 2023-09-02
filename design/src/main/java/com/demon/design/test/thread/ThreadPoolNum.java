package com.demon.design.test.thread;

/**
 *
 * @desc
 * @fileName ThreadPoolNum.java
 * @date 2023/3/12/0012 10:13
 * @author Dongmo.Wu
 */
public class ThreadPoolNum {
	public static void main(String[] args) {
		// R7-5800U 8核 16线程
		System.out.println(Runtime.getRuntime().availableProcessors()); // 16
	}
}
