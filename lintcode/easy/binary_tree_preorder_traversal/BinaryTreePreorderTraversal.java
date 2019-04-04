package easy.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Preorder Traversal (前序遍历):
 * NLR：访问根结点的操作发生在遍历其左右子树之前。
 * <p>
 * Example:
 * Given:
 * |     1
 * |    / \
 * |   2   3
 * |  / \
 * | 4   5
 * return [1,2,4,5,3].
 * <p>
 * Challenge:
 * Can you do it without recursion?
 */
public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
	
	}
	
	/**
	 * Non-recursive method
	 * This method is very important as it uses LinkedList as a stack structure.
	 *
	 * @param root A Tree
	 * @return Preorder in ArrayList which contains node values.
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		// Use LinkedList as a stack structure!!!
		LinkedList<TreeNode> list = new LinkedList<>();
		list.push(root);
		while (!list.isEmpty()) {
			TreeNode node = list.pop();
			res.add(node.val);
			if (node.right != null)
				list.push(node.right);
			if (node.left != null)
				list.push(node.left);
		}
		return res;
	}
	
	/**
	 * Recursive method (Trivial)
	 *
	 * @param root A Tree
	 * @return Preorder in ArrayList which contains node values.
	 */
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		recursive(root, res);
		return res;
	}
	
	private void recursive(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		
		res.add(root.val);
		recursive(root.left, res);
		recursive(root.right, res);
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
  