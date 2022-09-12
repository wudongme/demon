package com.demon.design.test.alibaba_tuning;

/**
 *
 * @desc
 * @fileName StringCompare.java
 * @date 2022/9/5/0005 14:57
 * @author Dongmo.Wu
 */
public class StringCompare {
	public String name;

	public StringCompare(String name) {
		this.name = name;
	}

	public StringCompare() {
	}

	public static void main(String[] args) {
		String s1 = "he";
		String s2 = "he";
		System.out.println(s1 == s2); // true

		String s3 = new String("she");
		String s4 = new String("she");
		System.out.println(s3 == s4);

		String s5 = new String("her").intern();
		String s6 = new String("her").intern();
		System.out.println(s5 == s6); // true

		String s7 = "him";
		String s8 = new String("him").intern();
		System.out.println(s7 == s8); // true

		String name =  "name";

		StringCompare obj1 = new StringCompare(name);
		StringCompare obj2 = new StringCompare(name);
		System.out.println("obj1.name == obj2.name : " + (obj1.name == obj2.name));

	}
}
