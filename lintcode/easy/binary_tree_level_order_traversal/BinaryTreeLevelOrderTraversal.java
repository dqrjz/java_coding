package easy.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * <p>
 * Example:
 * Given binary tree {3,9,20,#,#,15,7},
 * |     3
 * |    / \
 * |   9  20
 * |     /  \
 * |    15   7
 * return its level order traversal as:
 * |  [
 * |    [3],
 * |    [9,20],
 * |    [15,7]
 * |  ]
 * <p>
 * Challenge:
 * Challenge 1: Using only 1 queue to implement it.
 * Challenge 2: Use DFS algorithm to do it.
 */
public class BinaryTreeLevelOrderTraversal {
	/**
	 * @param root A Tree
	 * @return Level order a list of lists of integer
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		// TODO Untested & Challenge!
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> currLvl = new LinkedList<>();
		LinkedList<TreeNode> nextLvl = new LinkedList<>();
		TreeNode curr = root;
		currLvl.add(curr);
		while (!currLvl.isEmpty()) {
			List<Integer> lvl = new ArrayList<>();
			while (!currLvl.isEmpty()) {
				curr = currLvl.poll();
				lvl.add(curr.val);
				if (curr.left != null)
					nextLvl.offer(curr.left);
				if (curr.right != null)
					nextLvl.offer(curr.right);
			}
			if (lvl.size() != 0)
				res.add(lvl);
			currLvl = nextLvl;
			nextLvl = new LinkedList<>();
		}
		return res;
	}
}

class TreeNode {
	public int val;
	public TreeNode left, right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}