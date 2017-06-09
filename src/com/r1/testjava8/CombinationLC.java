package com.r1.testjava8;

import java.util.ArrayList;

public class CombinationLC {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4 };
		combine(A, 2);

	}

	public static ArrayList<ArrayList<Integer>> combine(int[] a, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (a.length <= 0 || a.length < k)
			return result;

		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(a, k, 0, item, result); // because it need to begin from 1

		return result;
	}

	private static void dfs(int[] a, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i < a.length; i++) {
			item.add(a[i]);
			dfs(a, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}

}
