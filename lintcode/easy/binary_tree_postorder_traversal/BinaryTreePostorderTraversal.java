package easy.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Postorder Traversal (后序遍历)：
 * LRN: 访问根结点的操作发生在遍历其左右子树之后。
 * <p>
 * Example：
 * Given binary tree {1,#,2,3},
 * |    1
 * |     \
 * |     2
 * |    /
 * |   3
 * return [3,2,1].
 * <p>
 * Challenge：
 * Can you do it without recursion?
 */
public class BinaryTreePostorderTraversal {
	/**
	 * Non-recursive method
	 * This method is very important!!!
	 *
	 * @param root A Tree
	 * @return Postorder in ArrayList which contains node values.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		// Use LinkedList as a stack structure!!!
		LinkedList<TreeNode> list = new LinkedList<>();
		TreeNode node = root;
		TreeNode prev = null;
		while (node != null) {
			list.push(node);
			node = node.left;
		}
		while (!list.isEmpty()) {
			node = list.peek();
			if (node.right != null && node.right != prev) {
				node = node.right;
				while (node != null) {
					list.push(node);
					node = node.left;
				}
			} else {
				node = list.pop();
				res.add(node.val);
				prev = node;
			}
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