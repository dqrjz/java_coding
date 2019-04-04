package com.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		List<String> list = generateParenthesis(3);
		System.out.println(list);
		System.out.println(list.size());
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backtrack(list, new StringBuilder(""), n, n);
		return list;
	}
	
	static void backtrack(List<String> list, StringBuilder sb, int open, int close) {
		
		if (close == 0) {
			list.add(sb.toString());
			return;
		}
		
		if (open > 0) {
			backtrack(list, sb.append("("), open - 1, close);
//			sb.deleteCharAt(sb.length()-1);
			sb.setLength(sb.length()-1);
		}
		if (close > open) {
			backtrack(list, sb.append(")"), open, close - 1);
//			sb.deleteCharAt(sb.length()-1);
			sb.setLength(sb.length()-1);
		}
	}
}
