package com.r1.linkedlist;

import java.util.ArrayList;

public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 2; i <= 10; i += 2)
			arrList.add(i);
		createLL(arrList, ll1);
		printLL(ll1);
		System.out.println("***************************");
		arrList.removeAll(arrList);
		for (int i = 1; i <= 10; i += 2)
			arrList.add(i);
		createLL(arrList, ll2);
		printLL(ll2);
		System.out.println("***************************");
		LinkedList ll = mergeLL(ll1, ll2);
		printLL(ll);

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

}
