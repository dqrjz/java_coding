package easy.reverse_linked_list;

/**
 * Reverse a linked list.
 * <p>
 * Example:
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * <p>
 * Challenge:
 * Reverse it in-place and in one-pass
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
		
		ListNode reversedHead = reverse(ln1);
		
		if (reversedHead == null)
			System.out.println(reversedHead);
		else {
			ListNode ln = reversedHead;
			while (ln != null) {
				if (ln.next != null)
					System.out.print(ln.val + "->");
				else
					System.out.print(ln.val);
				ln = ln.next;
			}
		}
	}
	
	/** Correct method */
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}

/** Definition for ListNode */
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
		next = null;
	}
}