package com.practice;

public class LinkedListTest {
	public static void main(String[] args) {
		MyLinkedList mll1 = new MyLinkedList(1);
		MyLinkedList mll2 = new MyLinkedList(2);
		MyLinkedList mll3 = new MyLinkedList(3);
		MyLinkedList mll4 = new MyLinkedList(4);
		MyLinkedList mll5 = new MyLinkedList(5);
		mll1.next = mll2;
		mll2.next = mll3;
		mll3.next = mll4;

//		deleteMe.next = mll3;
		MyLinkedList head = deleteElement2(mll1, mll5);
//
//		while (mll1 != null) {
//			System.out.println(mll1.val);
//			mll1 = mll1.next;
//		}
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	private static MyLinkedList deleteElement2(MyLinkedList head, MyLinkedList deleteMe) {
		MyLinkedList dummyHead = new MyLinkedList(0);
		dummyHead.next = head;
		MyLinkedList pointer = dummyHead;
		while (pointer != null) {
			if (pointer.next == deleteMe) {
				pointer.next = deleteMe.next;
				return dummyHead.next;
			}
			pointer = pointer.next;
		}
		return dummyHead.next;
	}
	
	private static MyLinkedList deleteElement(MyLinkedList head, MyLinkedList deleteMe) {
		if (head == deleteMe) {
			head = head.next;
			return head;
		}
		MyLinkedList mll = head;
		while (mll != null) {
			if (mll.next == deleteMe) {
				mll.next = deleteMe.next;
				return head;
			}
			mll = mll.next;
		}
		return head;
	}
}

class MyLinkedList {
	MyLinkedList next;
	int val;
	
	MyLinkedList(int val) {
		this.val = val;
	}
}