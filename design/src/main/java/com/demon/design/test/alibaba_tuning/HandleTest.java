package com.demon.design.test.alibaba_tuning;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @desc
 * @fileName HandleTest.java
 * @date 2022/9/5/0005 21:26
 * @author Dongmo.Wu
 */
public class HandleTest {

	public static void main(String[] args) throws Throwable {
		invokeExact();
	}

	public static void invokeExact()throws Throwable{
		// 1.先获取String类中substring的方法句柄.
		MethodHandles.Lookup lookup= MethodHandles.lookup();
		MethodType type=MethodType.methodType(String.class, int.class, int.class);
		MethodHandle mh=lookup.findVirtual(String.class, "substring", type);
		// 2.再通过invokeExact来进行调用。
		String str=(String)mh.invokeExact("Hello World",1,3);
		System.out.println(str);
	}
}
