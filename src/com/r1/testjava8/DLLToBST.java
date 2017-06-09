package com.r1.testjava8;

public class DLLToBST {
	public static BSTNode head = null;
	public static BSTNode tail = null;
	public static int size = 0;
	public BSTNode root;

	public void add(int data) {
		BSTNode n = new BSTNode(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
		size++;
	}

	public BSTNode dLLtoBST(int size) {
		if (size <= 0) {
			return null;
		}
		BSTNode left = dLLtoBST(size / 2);
		BSTNode root = head;
		root.prev = left;
		head = head.next;
		root.next = dLLtoBST(size - (size / 2) - 1);
		return root;
	}

	public void inOrder(BSTNode root) {
		if (root != null) {
			inOrder(root.prev);
			System.out.print(" " + root.data);
			inOrder(root.next);
		}
	}

	public void printDLL(BSTNode head) {
		BSTNode curr = head;
		while (curr != null) {
			System.out.print(" " + curr.data);
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		DLLToBST r = new DLLToBST();
		r.add(9);
		r.add(8);
		r.add(7);
		r.add(6);
		r.add(5);
		r.add(4);
		r.add(3);
		r.add(2);
		r.add(1);
		BSTNode h = head;
		System.out.println("DLL is : ");
		r.printDLL(h);
		BSTNode x = r.dLLtoBST(size);
		System.out.println("Inorder traversal of contructed BST");
		r.inOrder(x);
	}
}

class BSTNode {
	int data;
	BSTNode next;
	BSTNode prev;

	public BSTNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}