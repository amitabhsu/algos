package com.r1.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wffw {

	public static void main(String[] args) {

		int[] nums = { 1,2 };
		List<Integer> list =lexicalOrder(13);
		for(Integer i: list)
			System.out.println(i);
		int[] x = searchRange(nums, 1);
		for (int a : x)
			System.out.println(a);
	}
	
	public static List<Integer> lexicalOrder(int n) {
        String [] arr = new String[n];
        int idx=0;
        while(idx <n)
        {
            arr[idx]=String.valueOf(idx+1);
            idx++;
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for(String s : arr)
            list.add(Integer.parseInt(s));
        return list;
    }

	public static int[] searchRange(int[] nums, int target) {
		int idx = firstGreaterEqual(nums, target);
		if (idx == -1) {
			return new int[] { -1, -1 };
		}
		System.out.println(idx);
		int l = idx, r = idx;
		while (l >= 0 && nums[l] == target) {
			l--;
		}
		while (r < nums.length && nums[r] == target) {
			r++;
		}
		if (l < 0) {
			l = 0;
			return new int[] { l, r - 1 };
		}
		if (r > nums.length - 1) {
			r = nums.length - 1;
			return new int[] { l + 1, r };
		}
		return new int[] { l + 1, r - 1 };

	}

	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			// low <= mid < high
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
