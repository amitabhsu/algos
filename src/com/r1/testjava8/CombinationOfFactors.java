package com.r1.testjava8;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfFactors {

	public static void main(String[] args) {
		getFactors(8);

	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(2, 1, n, result, list);
		return result;
	}

	public static void helper(int start, int product, int n, List<List<Integer>> result, List<Integer> curr) {
		if (start > n || product > n)
			return;

		if (product == n) {
			ArrayList<Integer> t = new ArrayList<Integer>(curr);
			result.add(t);
			return;
		}

		for (int i = start; i < n; i++) {
			if (i * product > n)
				break;

			if (n % i == 0) {
				curr.add(i);
				helper(i, i * product, n, result, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}

}
