package com.leetcode.path_sum_III;


import java.util.HashMap;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
@SuppressWarnings("ALL")
public class PathSumIII {
	
	public int pathSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		return helper(root, 0, sum, preSum);
	}
	
	private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
		if (root == null) {
			return 0;
		}
		// update the prefix sum by adding the current val
		currSum += root.val;
		// get the number of valid path, ended by the current node
		int res = preSum.getOrDefault(currSum - target, 0);
		// update the map with the current sum, so the map is good to be passed to the next recursion
		preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
		// add the 3 parts discussed in 8. together
		res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
		// restore the map, as the recursion goes from the bottom to the top
		preSum.put(currSum, preSum.get(currSum) - 1);
		return res;
	}
	
	/**
	 * Simple Recursive solution
	 * Time Complexity O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
	 */
	public class Solution2 {
		public int pathSum(TreeNode root, int sum) {
			if (root == null)
				return 0;
			return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		}
		
		public int findPath(TreeNode root, int sum) {
			int res = 0;
			if (root == null)
				return res;
			if (sum == root.val)
				res++;
			res += findPath(root.left, sum - root.val);
			res += findPath(root.right, sum - root.val);
			return res;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}