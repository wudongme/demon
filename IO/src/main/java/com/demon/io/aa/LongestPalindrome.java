package com.demon.io.aa;

/**
 *
 * @desc
 * @fileName LongestPalindrome.java
 * @date 2023/7/4/0004 11:26
 * @author Dongmo.Wu
 */
public class LongestPalindrome {
	/*给你一个字符串 s，找到 s 中最长的回文子串。

	如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

	 

	示例 1：

	输入：s = "babad"
	输出："bab"
	解释："aba" 同样是符合题意的答案。
	示例 2：

	输入：s = "cbbd"
	输出："bb"

	提示：

	1 <= s.length <= 1000
	s 仅由数字和英文字母组成
	*/
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("daabcba"));;
	}

	public String longestPalindrome(String s) {
		// 11:28
		int length = s.length();
		// 5个元素， 0 1 2
		int i = 0, j = length - 1;
		StringBuilder biggestSb = new StringBuilder();
		StringBuilder curSb = new StringBuilder();
		for (; i < length && j >= 0; i++, j--) {
			char c = s.charAt(i);
			if (c == s.charAt(j)) {
				curSb.append(c);
			} else {
				if (curSb.length() > biggestSb.length()) {
					biggestSb.setLength(0);
					biggestSb.append(curSb);
					curSb.setLength(0);
				}
			}
		}
		if (biggestSb.length() == 0 && curSb.length() > 0) {
			return curSb.toString();
		}
		return biggestSb.toString();
	}
}
