package com.demon.io.aa;

/**
 *
 * @desc
 * @fileName PwdSimilarTest.java
 * @date 2023/9/15/0015 11:16
 * @author Dongmo.Wu
 */
public class PwdSimilarTest {
	public static void main(String[] args) {
		char[] newPwd = {1,2,3,4,5};
		char[] oldPwd = {5,2,3,4,5,6};
		System.out.println(checkSimilarity(newPwd, oldPwd));;


	}
	public static int lcsLength(char[] newPwd, char[] oldPwd) {
		int[][] dp = new int[newPwd.length+1][oldPwd.length+1];
		for (int i = 1; i <= newPwd.length; i++) {
			for (int j = 1; j <= oldPwd.length; j++) {
				if (newPwd[i-1] == oldPwd[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[newPwd.length][oldPwd.length];
	}

	// 检查新老密码相似性
	public static boolean checkSimilarity(char[] newPwd, char[] oldPwd) {
		int lcsLen = lcsLength(newPwd, oldPwd);
		return lcsLen > 3; // 相似性阈值,可调整
	}
}
