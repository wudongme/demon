package com.demon.design.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @desc
 * @fileName FutureTaskTest.java
 * @date 2022/10/29/0029 0:27
 * @author Dongmo.Wu
 */
public class FutureTaskTest {
	public static void main(String[] args) {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
			return testFutureTaskReturn();
		});
		Thread thread = new Thread(futureTask);
		thread.start();

		try {
			Integer testReturnVal = futureTask.get();
			System.out.println(testReturnVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	public void test() {

	}

	public static Integer testFutureTaskReturn() {
		System.out.println("-------------进入futureTask线程方法------------");
		sleep(3);
		System.out.println("-------------结束futureTask线程方法------------");
		return 0;
	}

	private static void sleep(Integer secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
