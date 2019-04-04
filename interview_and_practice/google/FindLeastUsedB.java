package com.google;

import java.util.*;

/**
 * 输入两个字符串A，B。输出用B字符串的子序列，最少拼接多少次得到字符串A。
 * 注意，是子序列不是连续子串。
 * A = 'zabaz', B = 'azb'
 * A = 'z' + 'ab' + 'az'
 * 所以答案是3
 */
public class FindLeastUsedB {
	public static void main(String[] args) {
		String A = "zabaz";
		String B = "azb";
		System.out.println(findLeastUsedB(A, B));
//		Map<Character, List<Integer>> map = new HashMap<>();
//		Random r = new Random();
//		r.nextInt()
//		ArrayList<String> list = new ArrayList<>();
//		list.subList()
//		list.toArray(new String[2]);
//		Stack stack = new Stack<>();
//		stack.empty();// boolean
//		int[] arr = new int[2];
//		ArrayList list = new ArrayList();
//		list.
	}
	
	private static int findLeastUsedB(String A, String B) {
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < B.length(); i++) {
			List<Integer> list = map.computeIfAbsent(B.charAt(i), k -> new ArrayList<>());
			list.add(i);
		}
		
		int index = 0;
		int res = 1;
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			List<Integer> list = map.get(c);
			if (list == null) {
				return -1; // which means there is no way to build the String A
			}
			int id = Collections.binarySearch(list, index);
			if (id < 0) {
				id = -id - 1;
			}
			if (id == list.size()) {
				res++;
				index = list.get(0) + 1;
			} else {
				index = list.get(id) + 1;
			}
		}
		return res;
	}
}
