package com.demon.design.test.design_pattern.decorator;

/**
 *
 * @desc
 * @fileName Demo1.java
 * @date 2022/8/30/0030 18:00
 * @author Dongmo.Wu
 */
public class Demo1 {
	public static void main(String[] args) {
		Impl1 impl1 = new Impl1();
		Impl2 impl2 = new Impl2(impl1);
		impl2.fun1();
	}
}

interface Interf {
	void fun1();
}

class Impl1 implements Interf {

	@Override
	public void fun1() {
		System.out.println("impl1 exec");
	}
}

class Impl2 implements Interf {
	private Interf interf;

	public Impl2(Interf interf) {
		this.interf = interf;
	}

	@Override
	public void fun1() {
		// 增强
		System.out.println("impl 增强");

		interf.fun1();

		System.out.println("impl2 exec");
	}
}
