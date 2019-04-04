package com.leetcode.interleaving_string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingString {
	public static void main(String[] args) {
		String s1 = "aabfc", s2 = "dbbca", s3 = "aadbbcbfac";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
//		System.out.println("s1=" + s1 + ", s2=" + s2 + ", s3=" + s3);
//		if (s1.isEmpty()) return s2.equals(s3);
//		if (s2.isEmpty()) return s1.equals(s3);
//		return (s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1))) ||
//				(s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));
		if (s3.length() != s1.length() + s2.length()) return false;
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
				} else {
					dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
							(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
