package com.demon.io.aa;

import java.util.Arrays;

/**
 *
 * @desc
 * @fileName HandOutCookies.java
 * @date 2023/7/5/0005 10:21
 * @author Dongmo.Wu
 */
public class HandOutCookies {
	public static void main(String[] args) {
		int [] g = {1, 10, 2, 3}, s = {1, 4};
		System.out.println(new HandOutCookies().findContentChildren(g, s));;
	}
	public int findContentChildren(int[] g, int[] s) {
		// 孩子
		Arrays.sort(g);
		// 饼干
		Arrays.sort(s);
		int cookieIdx = 0;
		int childIdx = 0;
		int count = 0;
		while (cookieIdx < s.length && childIdx < g.length) {
			if (g[childIdx] <= s[cookieIdx]) {
				childIdx++;
				cookieIdx++;
				count++;
			} else {
				cookieIdx++;
			}
		}
		return count;
	}
}
