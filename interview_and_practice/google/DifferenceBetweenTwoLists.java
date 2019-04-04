package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two lists of elements A and B (integers), compute the diff between them.
 * It should return two lists:
 * - Elements in A that are not in B
 * - Elements in B that are not in A.
 * <p>
 * For e.g.
 * Diff([1,2,3,4] [1,2,3]) = [4] and []
 * Diff([1,2,2,2], [1,2]) = [2,2] and []
 * Diff([1,2,2,2], [1,2,3,3,3]) = [2,2] and [3,3,3]
 */
public class DifferenceBetweenTwoLists {
	public static void main(String[] args) {
		List<Integer> listA = List.of(1, 2, 2, 2, 4, 5);
		List<Integer> listB = List.of(1, 2, 3, 3, 3, 5, 4, 4);
//		List<Integer> listA = new ArrayList<>();
//		listA.add(1);
//		listA.add(2);
//		listA.add(2);
//		listA.add(2);
//		List<Integer> listB = new ArrayList<>();
//		listB.add(1);
//		listB.add(2);
//		listB.add(3);
//		listB.add(3);
//		listB.add(3);
		List[] d1 = diff1(listA, listB);
		for (List list : d1) {
			System.out.println(list);
		}
		System.out.println("*************");
		List[] d2 = diff2(listA, listB);
		for (List list : d2) {
			System.out.println(list);
		}
	}
	
	private static List[] diff1(List<Integer> listA, List<Integer> listB) {
		HashMap<Integer, Integer> mapA = new HashMap<>();
		HashMap<Integer, Integer> mapB = new HashMap<>();
		for (Integer i : listA) {
			mapA.put(i, mapA.getOrDefault(i, 0) + 1);
		}
		System.out.println(mapA);
		for (Integer j : listB) {
			if (mapA.containsKey(j)) {
				mapA.put(j, mapA.get(j) - 1);
				if (mapA.get(j) == 0) mapA.remove(j);
			} else {
				mapB.put(j, mapB.getOrDefault(j, 0) + 1);
			}
		}
		System.out.println(mapA);
		System.out.println(mapB);
		List<Integer> tempA = new ArrayList<>();
		List<Integer> tempB = new ArrayList<>();
		for (Integer i : mapA.keySet()) {
			int count = mapA.get(i);
			while (count-- > 0) {
				tempA.add(i);
			}
		}
		for (Integer j : mapB.keySet()) {
			int count = mapB.get(j);
			while (count-- > 0) {
				tempB.add(j);
			}
		}
		return new List[]{tempA, tempB};
	}
	
	private static List[] diff2(List<Integer> listA, List<Integer> listB) {
		List<Integer> tempA = new ArrayList<>(listA);
		List<Integer> tempB = new ArrayList<>(listB);
		Integer e;
		int index = 0;
		int len = listA.size();
		for (int i = 0; i < len; i++) {
			e = tempA.get(index);
			if (tempB.contains(e)) {
				tempA.remove(index);
				tempB.remove(e);
			} else {
				index++;
			}
		}
		return new List[]{tempA, tempB};
	}
}
