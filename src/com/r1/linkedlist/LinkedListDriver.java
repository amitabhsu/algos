package com.r1.linkedlist;

import java.util.ArrayList;

public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ArrayList<Integer> arrList = new ArrayList<>();
		// for (int i = 1; i <= 2; i++)
		arrList.add(2);
		arrList.add(4);
		arrList.add(3);
		createLL(arrList, ll1);
		printLL(ll1);
		ArrayList<Integer> arrList1 = new ArrayList<>();
		arrList1.add(5);
		arrList1.add(6);
		arrList1.add(4);
		createLL(arrList1, ll2);
		printLL(ll2);
		addTwoNumbers(ll1.head, ll2.head);
		// removeElements(ll1.head,2);
		/*
		 * System.out.println("***************************");
		 * arrList.removeAll(arrList); for (int i = 1; i <= 10; i += 2)
		 * arrList.add(i); createLL(arrList, ll2); printLL(ll2);
		 * System.out.println("***************************"); LinkedList ll =
		 * mergeLL(ll1, ll2); printLL(ll);
		 */

	}

	public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		int carry = 0;
		int sum = 0;
		LinkedListNode head = null;
		LinkedListNode prev = null;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}
			LinkedListNode node = new LinkedListNode((sum + carry) % 10);
			if (head == null) {
				head = node;
			} else {
				prev.next = node;
			}
			prev = node;
			carry = (sum + carry) / 10;
		}
		if (carry == 1) {
			LinkedListNode n = new LinkedListNode(1);
			prev.next = n;
		}
		return head;

	}

	private static void createLL(ArrayList<Integer> list, LinkedList ll1) {
		LinkedListNode prev = null;
		for (Integer data : list) {
			LinkedListNode n = new LinkedListNode(data);
			if (ll1.head == null) {
				ll1.head = n;
			} else {
				prev.next = n;
			}
			prev = n;
		}

	}

	private static LinkedList mergeLL(LinkedList ll1, LinkedList ll2) {
		if (ll1.head == null)
			return ll2;
		if (ll2.head == null)
			return ll1;
		LinkedList ll = new LinkedList();
		ll.head = null;
		LinkedListNode cur = ll.head;
		LinkedListNode cur1 = ll1.head;
		LinkedListNode cur2 = ll2.head;
		LinkedListNode prev = null;
		while (cur1 != null && cur2 != null) {
			if (cur1.data == cur2.data) {
				prev = cur;
				if (cur != null)
					cur.next = cur1;
				else {
					cur = cur1;
					ll.head = cur;
				}
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			if (cur1.data < cur2.data) {
				prev = cur;
				if (cur != null)
					cur.next = cur1;
				else {
					cur = cur1;
					ll.head = cur;
				}
				cur1 = cur1.next;
			}
			if (cur2.data < cur1.data) {
				prev = cur;
				if (cur != null)
					cur.next = cur2;
				else {
					cur = cur2;
					ll.head = cur;
				}
				cur2 = cur2.next;
			}

		}
		if (cur1 != null)
			cur.next = cur2;
		if (cur2 != null)
			cur.next = cur1;
		return ll;
	}

	private static void splitLL(LinkedList ll) {
		if (ll.head == null || ll.head.next == null)
			return;
		LinkedList ll2 = new LinkedList();
		ll2.head = ll.head.next;
		LinkedListNode cur = ll2.head;
		while (cur != null) {

		}

	}

	private static void printLL(LinkedList ll) {
		LinkedListNode cur = ll.head;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
	}

	public static LinkedListNode removeElements(LinkedListNode head, int val) {
		if (head == null)
			return head;
		while (head != null && head.data == val) {
			head = head.next;
			// return head;
		}
		LinkedListNode cur = head;
		while (cur != null) {
			while (cur.data == val && cur.next != null) {
				cur.data = cur.next.data;
				cur.next = cur.next.next;
			}
			if (cur.data == val && cur.next == null) {
				cur = null;
				break;
			}
			cur = cur.next;
		}
		return head;
	}

}
