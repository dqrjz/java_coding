package easy.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Inorder Traversal (中序遍历)：
 * LNR: 访问根结点的操作发生在遍历其左右子树之间。
 * <p>
 * Example:
 * Given binary tree {1,#,2,3},
 * |    1
 * |     \
 * |      2
 * |     /
 * |    3
 * return [1,3,2].
 * <p>
 * Challenge:
 * Can you do it without recursion?
 */
public class BinaryTreeInorderTraversal {
	/**
	 * Non-recursive method
	 * This method is very important!
	 *
	 * @param root A Tree
	 * @return Inorder in ArrayList which contains node values.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		// Use LinkedList as a stack structure!!!
		LinkedList<TreeNode> list = new LinkedList<>();
		TreeNode node = root;
		while (!list.isEmpty() || node != null) {
			while (node != null) {
				list.push(node);
				node = node.left;
			}
			node = list.pop();
			res.add(node.val);
			node = node.right;
		}
		return res;
	}
}

/**
 * Definition of TreeNode:
 */
class TreeNode {
	public int val;
	public TreeNode left, right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}