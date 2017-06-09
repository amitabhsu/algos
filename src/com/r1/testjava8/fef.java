package com.r1.testjava8;

import java.util.Arrays;
import java.util.HashSet;

public class fef {

	public static void main(String[] args) {
		int[] a = { 3, 2, 4 };
		// twoSum(a, 6);
		removeDuplicateLetters("cbacdcbc");

	}

	public static String removeDuplicateLetters(String s) {
		boolean[] x = new boolean[26];
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; i++) {
			int j = str[i] - 'a';
			x[j] = true;

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length; i++) {
			// int j = str[i] - 'a';
			if (x[i])
				sb.append((char) (i + 'a'));
		}

		return sb.toString();
	}

	public static int[] twoSum(int[] nums, int target) {
		HashSet<Integer> hs = new HashSet<>();
		for (int num : nums)
			hs.add(num);
		int[] x = new int[2];
		for (int i = 0; i < nums.length; i++) {
			hs.remove(nums[i]);
			if (hs.contains(target - nums[i])) {
				int idx = search(nums, target - nums[i]);
				if (idx != -1) {
					x[0] = i;
					x[1] = idx;
					break;
				}
			}
			hs.add(nums[i]);
		}

		return x;
	}

	public static int search(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;

	}

}
