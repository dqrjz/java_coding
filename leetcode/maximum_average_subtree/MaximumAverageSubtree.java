package com.leetcode.maximum_average_subtree;

public class MaximumAverageSubtree {
	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(100);
		TreeNode node1 = new TreeNode(100);
		TreeNode node2 = new TreeNode(100);
		TreeNode node3 = new TreeNode(100);
		TreeNode node4 = new TreeNode(100);
		node0.left = node1;
		node0.right = node2;
	}
	
	private int[][] child = new int[10][10];
	void DFS(int i) {
		if (child[i][0] != 0) {
			for (int k = 1; k <= child[i][0]; k++) {
				DFS(child[i][k]);
			}
		}
		System.out.println(i);
	}

//	static TreeNode method(TreeNode root) {
//
//	}
}

class Vertex {

}

class TreeNode {
	public int val;
	public TreeNode left, right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}
