package com.leetcode.partition_labels;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * <p>
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * <p>
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */

@SuppressWarnings("SpellCheckingInspection")
public class PartitionLabels {
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));
	}
	
	public static List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<>();
		int start = 0;
		int end = 0; // inclusive
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, S.lastIndexOf(S.substring(i, i + 1)));
			if (i >= end) {
				res.add(end - start + 1);
				start = end = i + 1;
			}
		}
		return res;
	}
}
