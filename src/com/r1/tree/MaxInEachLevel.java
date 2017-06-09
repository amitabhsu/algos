package com.r1.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxInEachLevel {

	public static void main(String[] args) {
		TreeNode node = new TreeNode();
		List<List<Integer>> finalList = levelOrderBottom(node);

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {List<List<Integer>> finalValueList = new ArrayList<List<Integer>>();
	List<List<TreeNode>> finalList = new ArrayList<List<TreeNode>>();
	if (root == null) {
		return finalValueList;
	}
	List<TreeNode> list = new ArrayList<TreeNode>();
	list.add(root);
	finalList.add(list);
	int level = 1;
	while (true) {
		List<TreeNode> newList = new ArrayList<TreeNode>();
		list = finalList.get(level - 1);
		for (TreeNode n : list) {
			if (n.left != null)
				newList.add(n.left);
			if (n.right != null)
				newList.add(n.right);
		}
		if (newList.size() > 0) {
			finalList.add(newList);
		} else {
			break;
		}
		level++;
	}
	Iterator<List<TreeNode>> iter = finalList.iterator();
	while (iter.hasNext()) {
		List<Integer> list1 = new ArrayList<Integer>();
		Iterator<TreeNode> siter = iter.next().iterator();
		while (siter.hasNext()) {
			TreeNode s = siter.next();
			list1.add(s.val);
		}
		finalValueList.add(list1);
	}
	//Collections.reverse(finalValueList);
	return (finalValueList);}
}
