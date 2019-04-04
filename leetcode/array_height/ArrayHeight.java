package com.leetcode.array_height;

import java.util.ArrayList;

// Google 2019 Summer Intern OA
public class ArrayHeight {
	public static void main(String[] args) {
		int[] height = {5, 2, 1, 6, 8, 4, 0, 3};
		System.out.println(solution(height));
	}
	
	static int solution(int[] height) {
		ArrayList<Integer> minHeightList = new ArrayList<>();
		for (int h : height) {
			int j = 0;
			for (; j < minHeightList.size(); j++) {
				if (h < minHeightList.get(j)) {
					minHeightList.set(j, h);
					break;
				}
			}
			if (j == minHeightList.size()) minHeightList.add(h);
		}
		System.out.println(minHeightList);
		return minHeightList.size();
	}
}
