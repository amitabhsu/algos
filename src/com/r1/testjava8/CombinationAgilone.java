package com.r1.testjava8;

import java.util.ArrayList;

public class CombinationAgilone {

	public static void main(String[] args) {
		// int A[] = { 1, 2, 3, 4 };
		combine(10, 4);

	}

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (n <= 0 || n < k)
			return result;

		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 0, item, result); // because it need to begin from 1

		return result;
	}

	private static void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k && sum(item) == n) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i <=n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}

	private static int sum(ArrayList<Integer> list) {
		int sum = 0;
		for (int x : list)
			sum += x;
		return sum;
	}

}
