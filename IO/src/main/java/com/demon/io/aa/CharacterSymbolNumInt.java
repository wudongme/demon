package com.demon.io.aa;

/**
 *
 * @desc
 * @fileName CharacterSymbolNumInt.java
 * @date 2023/6/30/0030 16:48
 * @author Dongmo.Wu
 */
public class CharacterSymbolNumInt {
	public static void main(String[] args) {
		char ch;

		// English alphabets
		for (ch = 'A'; ch <= 'Z'; ch++) {
			int intValue = (int) ch;
			System.out.println(ch + " -> " + intValue);
		}

		for (ch = 'a'; ch <= 'z'; ch++) {
			int intValue = (int) ch;
			System.out.println(ch + " -> " + intValue);
		}

		// Symbols
		String symbols = "!@#$%^&*()";
		for (int i = 0; i < symbols.length(); i++) {
			ch = symbols.charAt(i);
			int intValue = (int) ch;
			System.out.println(ch + " -> " + intValue);
		}

		// Space
		ch = ' ';
		int intValue = (int) ch;
		System.out.println(ch + " -> " + intValue);
	}
}
