package com.r1.testjava8;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public static void main(String[] args) {
		int[] num = { 10, 1, 2, 7, 6, 1, 5 };
		ArrayList<ArrayList<Integer>> res = combinationSum2(num, 8);
		for (ArrayList<Integer> list : res) {
			for (Integer n : list)
				System.out.println(n);
			System.out.println("\n");
		}

	}

	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return result;
		Arrays.sort(num); // Sort the candidate in non-descending order
		ArrayList<Integer> current = new ArrayList<Integer>();
		recursiveAppend(num, target, 0, current, result);
		return result;
	}

	private static void recursiveAppend(int[] num, int target, int startIndex, ArrayList<Integer> current,
			ArrayList<ArrayList<Integer>> result) {
		if (target < 0)
			return;
		if (target == 0 && current.size() == 2) { // The current array is an
													// solution
			result.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = startIndex; i < num.length; i++) {
			if (num[i] > target) // No need to try the remaining candidates
				break;

			if (i > startIndex && num[i] == num[i - 1])
				// The same number has been added earlier within the loop
				continue;

			// Add candidate[i] to the current array

			current.add(num[i]);
			// Recursively append the current array to compose a solution

			recursiveAppend(num, target - num[i], i + 1, current, result);
			// Remove candidate[i] from the current array, and try next
			// candidate in the next loop
			current.remove(current.size() - 1);

		}

	}

}
