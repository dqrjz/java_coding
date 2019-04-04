package naive.binary_tree_maximum_node;

/**
 * Find the maximum node in a binary tree, return the node.
 * <p>
 * Example:
 * Given a binary tree:
 * <p>
 * 1
 * /   \
 * -5     2
 * / \   /  \
 * 0   3 -4  -5
 * return the node with value 3.
 * <p>
 * Definition of TreeNode:
 */
//public class TreeNode {
//	public int val;
//	public TreeNode left, right;
//
//	public TreeNode(int val) {
//		this.val = val;
//		this.left = this.right = null;
//	}
//}

public class BinaryTreeMaximumNode {
	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(-5);
		TreeNode tn3 = new TreeNode(2);
		TreeNode tn4 = new TreeNode(0);
		TreeNode tn5 = new TreeNode(3);
		TreeNode tn6 = new TreeNode(-4);
		TreeNode tn7 = new TreeNode(-5);
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn3.right = tn7;
		
		TreeNode maxNode = maxNode(tn1);
		System.out.println(maxNode.val);
	}
	
	/**
	 * @param root the root of tree
	 * @return the max node
	 */
	public static TreeNode maxNode(TreeNode root) {
		if (root == null) return null;
		TreeNode max = root;
		if (root.left != null) {
			TreeNode leftMax = maxNode(root.left);
			max = leftMax.val < max.val ? max : leftMax;
		}
		if (root.right != null) {
			TreeNode rightMax = maxNode(root.right);
			max = rightMax.val < max.val ? max : rightMax;
		}
		return max;
	}
}
