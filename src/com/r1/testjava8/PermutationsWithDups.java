package com.r1.testjava8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationsWithDups {
	public static void main(String[] args) {
		int[] nums = { -1, 2, -1, 2, 1, -1, 2, 1 };
		permuteUnique(nums);

	}

	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (num.length < 1)
			return results;
		if (num.length == 1) {
			ArrayList<Integer> perm = new ArrayList<Integer>();
			perm.add(num[0]);
			results.add(perm);
			return results;
		}
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i = 0; i < num.length; ++i) {
			
			if (visited.get(num[i]) != null)
				continue;
			visited.put(num[i], true);
			//the above 3 lines not required if no dups
			// copy a new array of n-1 numbers
			int[] subset = new int[num.length - 1];
			for (int j = 0; j < i; ++j)
				subset[j] = num[j];
			for (int j = i + 1; j < num.length; ++j)
				subset[j - 1] = num[j];
			// append the current number to the end of pernutations of n-1
			// subset
			for (List<Integer> perm : permuteUnique(subset)) {
				perm.add(num[i]);
				results.add(perm);
			}
		}
		return results;
	}

}
