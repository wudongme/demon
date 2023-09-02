package com.demon.design.test.jvm;

/**
 *
 * @desc
 * @fileName MemoryLeak.java
 * @date 2022/11/8/0008 13:31
 * @author Dongmo.Wu
 */


import java.util.*;
import java.util.concurrent.TimeUnit;

public class MemoryLeak {
	static Map wMap = new WeakHashMap();
	static Map map = new HashMap();

	private List list;

	public static void main(String[] args) {
		init();
		testWeakHashMap();
		testHashMap();
	}

	public void initList() {
		new Thread(() -> {
			List list1 = new ArrayList();
			list1.add("111");
			list1.add("222");
			list = list1;
		}).start();



		System.gc();



	}


	public static void init(){
		String ref1= new String("obejct1");
		String ref2 = new String("obejct2");
		String ref3 = new String ("obejct3");
		String ref4 = new String ("obejct4");
		wMap.put(ref1, "chaheObject1");
		wMap.put(ref2, "chaheObject2");
		map.put(ref3, "chaheObject3");
		map.put(ref4, "chaheObject4");
		System.out.println("String引用ref1，ref2，ref3，ref4 消失");

	}
	public static void testWeakHashMap(){

		System.out.println("WeakHashMap GC之前");
		for (Object o : wMap.entrySet()) {
			System.out.println(o);
		}
		try {
			System.gc();
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("WeakHashMap GC之后");
		for (Object o : wMap.entrySet()) {
			System.out.println(o);
		}
	}
	public static void testHashMap(){
		System.out.println("HashMap GC之前");
		for (Object o : map.entrySet()) {
			System.out.println(o);
		}
		try {
			System.gc();
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("HashMap GC之后");
		for (Object o : map.entrySet()) {
			System.out.println(o);
		}
	}
}