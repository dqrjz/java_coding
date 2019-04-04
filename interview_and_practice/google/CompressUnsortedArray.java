package com.google;

import java.util.*;

/**
 * 给定一个sorted没有duplicates的int list，return compress后的array。
 * 写出来以后写一个contains()的method return某个element在不在你compress过的array里
 * [2, 3, 4, 6, 8, 9, 11, ...] -> [2:4, 6, 8:9, 11, ...]
 * compress array自己选representation
 * contains的话就是一个高级版的binary search
 */
public class CompressUnsortedArray {
	public static void main(String[] args) {
		Integer[] arr = {2, 3, 4, 6, 8, 9, 11};
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
		ArrayList<int[]> compressed = compressUnsortedArray(list);
		for (int[] range : compressed) {
			System.out.println(range[0] + ":" + range[1]);
		}
		for (int e = 0; e < 13; e++) {
			System.out.println(e + ": " + contains(compressed, e));
		}
	}
	
	private static ArrayList<int[]> compressUnsortedArray(ArrayList<Integer> list) {
		ArrayList<int[]> compressed = new ArrayList<>();
		if (list == null || list.isEmpty()) return compressed;
		int[] range = new int[]{list.get(0), list.get(0)};
		compressed.add(range);
		int e;
		for (int i = 1; i < list.size(); i++) {
			e = list.get(i);
			if (e == range[1] + 1) {
				range[1] = e;
			} else {
				range = new int[]{e, e};
				compressed.add(range);
			}
		}
		return compressed;
	}
	
	private static boolean contains(ArrayList<int[]> compressedArray, int e) {
		int l = 0, r = compressedArray.size() - 1;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (compressedArray.get(m)[0] <= e && e <= compressedArray.get(m)[1]) {
				return true;
			} else if (e < compressedArray.get(m)[0]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return false;
	}
}
