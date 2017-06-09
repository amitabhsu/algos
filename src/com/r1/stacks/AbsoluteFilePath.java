package com.r1.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeSet;

public class AbsoluteFilePath {

	// dir
	// subdir1
	// subdir2
	// file.ext

	public static void main(String[] args) {
		lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
		int[][] a = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		maxEnvelopes(a);
		calculate("3+2*5");
		getFactors(37);
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();

		if (n <= 1) {
			return result;
		}

		List<Integer> curr = new ArrayList<>();

		getFactorsHelper(2, 1, n, curr, result);
		System.out.println("");
		return result;
	}

	private static void getFactorsHelper(int start, int product, int n, List<Integer> curr,
			List<List<Integer>> result) {
		/*if (start > n || product > n) {
			return;
		}*/

		if (product == n) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = start; i < n; i++) {
			if (i * product > n) {
				return;
			}

			if (n % (product * i) == 0) {
				curr.add(i);
				getFactorsHelper(i, product * i, n, curr, result);
				curr.remove(curr.size() - 1);
			}
		}
	}

	public static int calculate(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}

	public static int lengthLongestPath(String input) {
		int longest = 0;
		String[] lines = input.split("\n");
		int[] lens = new int[lines.length + 1];
		for (String line : lines) {
			String[] subs = line.split("\t");
			String cur = subs[subs.length - 1];
			int len = lens[subs.length - 1] + cur.length() + 1;
			if (cur.contains("."))
				longest = Math.max(longest, len - 1);
			else
				lens[subs.length] = len;
		}
		return longest;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length <= 1 || k <= 0 || t < 0) {
			return false;
		}

		TreeSet<Integer> treeSet = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			Integer floor = treeSet.floor(nums[i] + t);
			Integer ceil = treeSet.ceiling(nums[i] - t);

			if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
				return true;
			}

			treeSet.add(nums[i]);

			if (i >= k) {
				treeSet.remove(nums[i - k]);
			}
		}

		return false;
	}

	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0)
			return 0;

		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0]; // ascending order
				} else {
					return b[1] - a[1]; // descending order
				}
			}
		});

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < envelopes.length; i++) {

			if (list.size() == 0 || list.get(list.size() - 1) < envelopes[i][1])
				list.add(envelopes[i][1]);

			int l = 0;
			int r = list.size() - 1;

			while (l < r) {
				int m = l + (r - l) / 2;
				if (list.get(m) < envelopes[i][1]) {
					l = m + 1;
				} else {
					r = m;
				}
			}

			list.set(r, envelopes[i][1]);
		}

		return list.size();
	}

}
