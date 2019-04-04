package com.leetcode.longest_valid_parentheses;

import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		String s = ")()())())))((())())))()";
		//                     ((())())      max = 8
		System.out.println(longestValidParentheses(s));
		System.out.println(longestValidParentheses2(s));
	}
	
	/**
	 * Using a stack
	 *
	 * @param s input string containing left and right parentheses
	 * @return length of the longest valid parentheses substring
	 */
	static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}
	
	/**
	 * Constant space
	 *
	 * @param s input string containing left and right parentheses
	 * @return length of the longest valid parentheses substring
	 */
	static int longestValidParentheses2(String s) {
		int left = 0, right = 0;
		int max = 0;
		
		// Left to Right Scan
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				left++;
			else
				right++;
			
			if (left == right) {
				max = Math.max(max, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
		}
		
		left = right = 0;
		// Right to Left Scan
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(')
				left++;
			else
				right++;
			
			if (left == right) {
				max = Math.max(max, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
		}
		
		return max;
	}
}
