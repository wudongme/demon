package com.demon.io.aa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @desc
 * @fileName SubStrNoRepeat.java
 * @date 2023/6/30/0030 16:17
 * @author Dongmo.Wu
 */
public class SubStrNoRepeat {
	/*
	* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
	* */
	public static void main(String[] args) {
		// 16:24
		System.out.println(lengthOfLongestSubstring("avvas"));;

	}

	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int left = 0;
		for (int i = 0; i < length; i++) {
			Integer idx = map.get(s.charAt(i));
			if (idx != null) {
				//left = Math.max(left, idx + 1);
				// 当avvas 到 avv的时候，left = 0，i=2,idx = 1 此时应该left新值应该是上一个出现的字符的角标+1
				// 当avvas 到 avva的时候，left是上一次的重复的字符的角标，left=1+1=2， 当前i=3，或者是上一个字符a的角标0+1，然后取最近的重复的位置作为left
				left = Math.max(left, idx + 1);
			}
			// 不重复时
			map.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
}
