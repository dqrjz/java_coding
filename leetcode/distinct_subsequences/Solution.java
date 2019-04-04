package com.leetcode.distinct_subsequences;

import java.util.ArrayList;

/**
 * @author miracle
 * 切割钢条问题：
 * 长度：1	2	3	4	5	6	7	8	9	10
 * 价格：1	5	8	9	10	17	17	20	24	30
 * 问长度为n的钢条的最多卖多少钱
 */
public class Solution {
	
	int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
	ArrayList<Integer> priceList = new ArrayList<>();
	int[] dp = new int[prices.length];
	
	public static void main(String args[]) {
		Solution s = new Solution();
		for (int price : s.prices) {
			System.out.print(price + ", ");
		}
		System.out.println();
//		System.out.println(s.solve(s.prices, 1));
//		System.out.println(s.solve(s.prices, 2));
//		System.out.println(s.solve(s.prices, 3));
		System.out.println(s.solve(s.prices, 4));
		System.out.println(s.solve(s.prices, 5));
		
//		System.out.println(s.solveWithMemoUpToBottom(s.prices, 1));
//		System.out.println(s.solveWithMemoUpToBottom(s.prices, 2));
//		System.out.println(s.solveWithMemoUpToBottom(s.prices, 3));
		System.out.println(s.solveWithMemoUpToBottom(s.prices, 4));
		System.out.println(s.solveWithMemoUpToBottom(s.prices, 5));
		
//		System.out.println(s.solveBottomToUp(s.prices, 1));
//		System.out.println(s.solveBottomToUp(s.prices, 2));
//		System.out.println(s.solveBottomToUp(s.prices, 3));
//		System.out.println(s.solveBottomToUp(s.prices, 4));
//		System.out.println(s.solveBottomToUp(s.prices, 5));
	}
	
	public int solve(int[] prices, int n) {
		if (n == 0) {
//			System.out.println("n = " + 0 + " --> return " + 0);
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
//			System.out.println("n = " + n + "; i = " + i);
			max = Math.max(max, prices[i] + solve(prices, n - i));
//			System.out.println("n = " + n + "; i = " + i + " --> max = " + max);
		}
		return max;
	}
	
	public int solveWithMemoUpToBottom(int[] prices, int n) {
		if (n == 0 || dp[n] > 0) return dp[n];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, prices[i] + solveWithMemoUpToBottom(prices, n - i));
		}
		dp[n] = max;
		return max;
	}
	
	public int solveBottomToUp(int[] prices, int n) {
		int[] dp = new int[prices.length];
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				max = Math.max(max, prices[j] + prices[i - j]);
			}
			dp[i] = max;
		}
		return dp[n];
	}
}
