package com.demon.design.test.alibaba_tuning.intern_demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @desc
 * @fileName InternMain.java
 * @date 2022/9/5/0005 15:10
 * @author Dongmo.Wu
 */
public class InternMain {
	public static void main(String[] args) {
		AllInfoDo allInfoDo1 = new AllInfoDo("11", "22", "33");
		AllInfoDo allInfoDo2 = new AllInfoDo("11", "22", "33");

		System.out.println(allInfoDo1.getCity() == allInfoDo2.getCity());

		String city = "ny";

		allInfoDo1.setCity(city);
		city = "la";
		System.out.println("allInfoDo1.getCity() : " + allInfoDo1.getCity());
		System.out.println("city : " + city);
	}


}
