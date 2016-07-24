package com.r1.testjava8;

public class FixBST {

	public static TreeNode one = new TreeNode(-1);
	public static TreeNode two = new TreeNode(-1);
	public static TreeNode three = new TreeNode(-1);
	public static TreeNode prev = new TreeNode(-1);

	public static void printInorder(TreeNode n) {
		if (n == null)
			return;
		printInorder(n.left);
		System.out.println(n.val);
		printInorder(n.right);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(10);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(12);
		root.right.left = new TreeNode(7);

		System.out.println("Inorder Traversal of the original tree \n");
		printInorder(root);

		FixBST.recoverTree(root);
		System.out.println("\nInorder Traversal of the fixed tree \n");
		printInorder(root);

		return;

	}

	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;
		FixBST.fixTree(root);
		if (one.val != -1 && three.val != -1) {
			// swap (1,3)
			int temp = one.val;
			one.val = three.val;
			three.val = temp;
		} else if (one.val != -1 && two.val != -1) {
			// swap(1,2)
			int temp = one.val;
			one.val = two.val;
			two.val = temp;

		}

	}

	private static void fixTree(TreeNode root) {
		if (root != null) {
			fixTree(root.left);
			if (prev.val > root.val) {
				if (one.val == -1) {
					one = prev;
					two = root;
				} else {
					three = root;
				}

			}
			prev = root;
			fixTree(root.right);
		}
		return;
	}

}
