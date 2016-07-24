package com.r1.linkedlist;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int value =ThreeSum.threeSum(nums, 1);
		System.out.println(value);

	}

	public static int threeSum(int[] nums, int target) {
		java.util.Arrays.sort(nums);
		for (int num : nums)
			System.out.println(num);
		// -4,-1,1,2
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
		for (int i = nums.length - 1; i > 0; i--) {
			int start = 0;
			int end = i - 1;
			while (start < end) {
				if (nums[i] + nums[start] + nums[end] == target) {
					return (nums[i] + nums[start] + nums[end]);

				}
				if (nums[i] + nums[start] + nums[end] > target) {
					if (Math.abs(target - (a + b + c)) > Math.abs(target - (nums[i] + nums[start] + nums[end]))) {
						a = nums[i];
						b = nums[start];
						c = nums[end];
					}
					end--;
				}
				if (nums[i] + nums[start] + nums[end] < target) {
					if (Math.abs(target - (a + b + c)) > Math.abs(target - (nums[i] + nums[start] + nums[end]))) {
						a = nums[i];
						b = nums[start];
						c = nums[end];
					}
					start++;
				}
			}

		}
		return (a + b + c);
	}

}
