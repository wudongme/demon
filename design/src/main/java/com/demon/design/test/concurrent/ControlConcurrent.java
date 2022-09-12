package com.demon.design.test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @desc
 * @fileName ControlConcurrent.java
 * @date 2022/9/12/0012 10:33
 * @author Dongmo.Wu
 */
public class ControlConcurrent {

	private static ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static Boolean control(int concurNum) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(concurNum);

		for (int i = 0; i < 2; i++) {
			executorService.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " 开始执行");
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " 执行完成");
				countDownLatch.countDown();
			});
			/*new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " 开始执行");
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " 执行完成");
				countDownLatch.countDown();
			}).start();*/
		}

		countDownLatch.await();
		System.out.println("主线程结束");

		return null;
	}

	public static void main(String[] args) throws InterruptedException {
		control(2);
		System.out.println("主线程结束");
	}
}

class Runss implements Runnable {

	@Override
	public void run() {

	}
}
