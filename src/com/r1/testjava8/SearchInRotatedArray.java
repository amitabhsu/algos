package com.r1.testjava8;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] nums = { 3, 1 };
		int x = search(nums, 1);
		System.out.println(x);
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && nums[mid] > target)
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (nums[mid] < target && nums[right] >= target)
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

}
