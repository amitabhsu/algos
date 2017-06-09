package com.r1.testjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution1 {

	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.contains(i)) {
				pq.offer(i);
				set.add(i);
				if (pq.size() > 3) {
					set.remove(pq.poll());
				}
			}
		}
		if (pq.size() < 3) {
			while (pq.size() > 1) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			while (j < nums.length && j <= i + k) {
				if (nums[j] <= nums[i] + t)
					return true;
				j++;
			}
		}
		return false;
	}

	public static void slidingMedian(int[] a, int k) {
		double[] res = new double[a.length - k + 1];
		int count = 0;
		ArrayList<Integer> q = new ArrayList<>();
		for (int i = 0; i < a.length - k + 1; i++) {
			int x = 0;
			while (i + x < a.length && x < k) {
				q.add(a[i + x]);
				x++;
			}
			Collections.sort(q);
			int s1 = q.size() - 1;
			if (s1 % 2 != 0) {
				int s = s1 / 2;
				res[count++] = (q.get(s) + q.get(s + 1)) / 2.0;
			} else {
				res[count++] = q.get(q.size() / 2);
			}
			q.clear();
		}
		System.out.println("..");
	}

	public static void printCells() {
		int i = 7, j = 8;
		for (int a = i / 3 * 3; a < i / 3 * 3 + 3; a++) {
			for (int b = j / 3 * 3; b < j / 3 * 3 + 3; b++) {
				System.out.println(a + " " + b);

			}
		}
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		int idx1 = 0, idx2 = 0;
		while (idx1 < s.length()) {
			while ((idx2 < t.length()) && s.charAt(idx1) != t.charAt(idx2))
				idx2++;
			if (idx2 == t.length() && idx1 != (s.length()-1))
				return false;
			idx1++;
			idx2++;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] nums1 = { 1, 4, 2, 3 };
		isSubsequence("b", "c");
		// printCells();
		// thirdMax(nums1);
		// slidingMedian(nums1, 4);

	}
}
