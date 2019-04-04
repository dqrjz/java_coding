package com.leetcode.exactly_k_characters;

import java.util.Arrays;

public class ExactlyKCharacters {
	public static void main(String[] args) {
		System.out.println(method("abafg", 2));
	}
	
	static int method(String inputString, int num){
		if (inputString == null || inputString.length() == 0 || num == 0) {
			return 0;
		}
		int len = inputString.length();
		if (num > len) {
			return 0;
		}
		int res = 0;
		int[] alphabet = new int[26];
		for (int i = 0; i < len - num + 1; i++) {
			int count = 0;
			Arrays.fill(alphabet, 0);
			for (int j = i; j < len; j++) {
				int index = inputString.charAt(j) - 'a';
				if (alphabet[index] == 0) {
					count++;
					alphabet[index]++;
				}
				if (count == num) {
					res++;
				}
			}
		}
		return res;
	}
}
