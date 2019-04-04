package com.leetcode.stores_and_houses;

import java.util.Arrays;

public class StoresAndHouses {
	public static void main(String[] args) {
		int[] store = {10, 9, 8, 7, 6, 5};
		int[] house = {1, 6, 100};
		System.out.println(Arrays.toString(solution(store, house)));
	}
	
	static int[] solution(int[] stores, int[] houses) {
		int[] res = new int[houses.length];
		Arrays.sort(stores);
		System.out.println(Arrays.toString(stores));
		for (int i = 0; i < houses.length; i++) {
			res[i] = binarySearch(stores, houses[i]);
		}
		return res;
	}
	
	private static int binarySearch(int[] stores, int h) {
		int l = 0, r = stores.length - 1;
		int m;
		while (l + 1 < r) {
			m = l + (r - l) / 2;
			if (h > stores[m]) {
				l = m;
			} else if (h == stores[m]) {
				return stores[m];
			} else {
				r = m;
			}
//			System.out.println("l=" + l + ";r=" + r);
		}
		return (Math.abs(stores[l] - h) <= Math.abs(stores[r] - h)) ? stores[l] : stores[r];
	}
}














