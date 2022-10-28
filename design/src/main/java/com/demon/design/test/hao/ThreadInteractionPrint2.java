package com.demon.design.test.hao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 *
 * @desc
 * @fileName ThreadInteractionPrint.java
 * @date 2022/10/26/0026 14:50
 * @author Dongmo.Wu
 */
public class ThreadInteractionPrint2 {
	public static void main(String[] args) {

		//method1();
		String s = "ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE";
		for (int i = 0; i < s.length(); i = i + 5) {
			if (i >= s.length() - 1) {
				System.out.println(s.substring(i, s.length()));
				break;
			}

			if (i + 5 >= s.length()) {
				System.out.println(s.substring(i, s.length()));
				break;
			}

			if (!"ABCDE".equals(s.substring(i, i + 5))) {
				System.out.println(s.substring(i, i + 5));
			}
			//System.out.println(i);
		}
		//System.out.println();
		//System.out.println(s.length() + "----");


	}

	public static void method1() {
		new Thread(new ThreadPrint2('A')).start();
		new Thread(new ThreadPrint2('B')).start();
		new Thread(new ThreadPrint2('C')).start();
		new Thread(new ThreadPrint2('D')).start();
		new Thread(new ThreadPrint2('E')).start();

	}

}

class ThreadPrint2 implements Runnable {
	private static int idx = 1;
	private char ch;
	public static List<Character> list = new ArrayList<>(50000);


	public ThreadPrint2(char ch) {
		this.ch = ch;
	}

	@Override
	public void run() {
		while (true) {
			/*synchronized (ThreadPrint2.class) {

			}*/
			if (ch == 'A' && idx == 1) {
				System.out.print(ch);
				list.add(ch);
				idx++;
			} else if (ch == 'B' && idx == 2) {
				System.out.print(ch);
				list.add(ch);
				idx++;
			} else if (ch == 'C' && idx == 3) {
				System.out.print(ch);
				list.add(ch);
				idx++;
			} else if (ch == 'D' && idx == 4) {
				System.out.print(ch);
				list.add(ch);
				idx++;
			} else if (ch == 'E' && idx == 5) {
				System.out.print(ch);
				list.add(ch);
				idx = 1;
			}

			try {
				Thread.sleep(10 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
