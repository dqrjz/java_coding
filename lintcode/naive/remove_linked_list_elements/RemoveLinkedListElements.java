package naive.remove_linked_list_elements;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 * <p>
 * Definition for singly-linked list.
 */
//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }

public class RemoveLinkedListElements {
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(1);
		ListNode ln3 = null;
//		ListNode ln4 = new ListNode(3);
//		ListNode ln5 = new ListNode(4);
//		ListNode ln6 = new ListNode(5);
//		ListNode ln7 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
//		ln3.next = ln4;
//		ln4.next = ln5;
//		ln5.next = ln6;
//		ln6.next = ln7;
		
		ListNode ln = removeElements(ln1, 1);
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
	}
	
	/** My original method */
	public static ListNode removeElements(ListNode head, int val) {
		while (true) {
			if (head == null)
				return null;
			else if (head.val == val) head = head.next;
			else break;
		}
		ListNode ln = head;
		while (ln.next != null) {
			if (ln.next.val == val) ln.next = ln.next.next;
			else ln = ln.next;
		}
		return head;
	}
}

