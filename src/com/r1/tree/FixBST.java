package com.r1.tree;

public class FixBST {

	// eg. 6, 3, 4, 5, 2

	// We compare each node with its next one and we can find out that 6 is the
	// first element to swap because 6 > 3 and 2 is the second element to swap
	// because 2 < 5.

	TreeNode firstElement = null;
	TreeNode secondElement = null;
	// The reason for this initialization is to avoid null pointer exception in
	// the first comparison when prevElement has not been initialized
	TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer
		// to 6 in the example above)
		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root
		// (refer to 2 in the example above)
		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;

		// End of "do some business"

		traverse(root.right);
	}

}
