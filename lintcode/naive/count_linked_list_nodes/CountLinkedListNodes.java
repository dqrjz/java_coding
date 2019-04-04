package naive.count_linked_list_nodes;

/**
 * Count how many nodes in a linked list.
 * <p>
 * Example: Given 1->3->5, return 3.
 * <p>
 * Definition for ListNode.
 */
//public class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int val) {
//		this.val = val;
//		this.next = null;
//	}
//}

public class CountLinkedListNodes {
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(3);
		ListNode ln3 = new ListNode(5);
		ListNode ln4 = null;
//		ListNode ln5 = new ListNode(4);
//		ListNode ln6 = new ListNode(5);
//		ListNode ln7 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
//		ln4.next = ln5;
//		ln5.next = ln6;
//		ln6.next = ln7;
		
		int count = countNodes(ln1);
		System.out.print(count);
	}
	
	/**
	 * @param head the first node of linked list.
	 * @return An integer
	 */
	public static int countNodes(ListNode head) {
		int count = 0;
		ListNode ln = head;
		while (ln != null) {
			count++;
			if (ln.next != null)
				ln = ln.next;
			else break;
		}
		return count;
	}
}
