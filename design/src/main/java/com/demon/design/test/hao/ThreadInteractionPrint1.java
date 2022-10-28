package com.demon.design.test.hao;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @desc
 * @fileName ThreadInteractionPrint.java
 * @date 2022/10/26/0026 14:50
 * @author Dongmo.Wu
 */
public class ThreadInteractionPrint1 {
	public static void main(String[] args) {
		method1();
	}

	public static void method1() {
		new Thread(new ThreadPrint2('A')).start();
		new Thread(new ThreadPrint2('B')).start();
		new Thread(new ThreadPrint2('C')).start();

	}

}

class ThreadPrint1 implements Runnable {
	private static AtomicInteger idx = new AtomicInteger(1);
	private char ch;

	public ThreadPrint1(char ch) {
		this.ch = ch;
	}

	@Override
	public void run() {
		while (true) {
			if (ch == 'A' && idx.get() == 1) {
				System.out.println(ch);
				idx.incrementAndGet();
			} else if (ch == 'B' && idx.get() == 2) {
				System.out.println(ch);
				idx.incrementAndGet();
			} else if (ch == 'C' && idx.get() == 3) {
				System.out.println(ch);
				idx.set(1);
			}
		}
	}
}
