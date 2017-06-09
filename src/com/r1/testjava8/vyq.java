package com.r1.testjava8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class vyq {

	public static void main(String[] args) {
		//int[] nums = { 0, 1, 2, 4, 5, 7 };
		int[] nums = { 1, 1, 1,1 };
		List<String> list = summaryRanges(nums);
		for (String value : list)
			System.out.println(value);
		// minSubArrayLen(4,nums);
		// compareVersion("1", "1.1");
		//System.out.println(reverseWords("   a   b "));
		System.out.println("\n");
		System.out.println(removeDuplicates(nums));

	}

	public static List<String> summaryRanges(int[] nums) {
		int start = 0;
		List<String> l = new ArrayList<>();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] + 1 != nums[i]) {
				String s;
				if (start == i - 1)
					s = String.valueOf(nums[start]);
				else
					s = String.valueOf(nums[start]) + "->" + String.valueOf(nums[i - 1]);
				start = i;
				l.add(s);
			}
		}

		return l;
	}

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		int j = 0;
		int curSum = 0;
		int minLen = Integer.MAX_VALUE;
		while (j < nums.length) {
			while (curSum < s && j < nums.length) {
				curSum += nums[j];
				j++;
			}
			System.out.println(curSum);
			while (curSum >= s && i < nums.length) {
				curSum -= nums[i];
				i++;
				minLen = Math.min(j - i + 1, minLen);
			}
		}
		System.out.println(">>>>" + minLen);
		return minLen;
	}

	public static int compareVersion(String version1, String version2) {
		if (version1 == null && version2 != null)
			return -1;
		if (version2 == null && version1 != null)
			return 1;
		if (version1 == null && version2 == null)
			return 0;
		String maj1, min1, maj2, min2;
		if (version1.contains(".")) {
			String[] ver1 = version1.split("\\.");
			maj1 = ver1[0];
			min1 = ver1[1];
			System.out.println(maj1 + " " + min1);
		} else {
			maj1 = version1;
			min1 = null;
		}
		if (version2.contains(".")) {
			String[] ver2 = version2.split("\\.");
			maj2 = ver2[0];
			min2 = ver2[1];
			System.out.println(maj2 + " " + min2);
		} else {
			maj2 = version2;
			min2 = null;
		}
		int mj1, mn1, mj2, mn2;
		mj1 = Integer.valueOf(maj1);
		if (min1 != null)
			mn1 = Integer.valueOf(min1);
		else
			mn1 = Integer.MIN_VALUE;
		mj2 = Integer.valueOf(maj2);
		if (min2 != null)
			mn2 = Integer.valueOf(min2);
		else
			mn2 = Integer.MIN_VALUE;
		if (mj1 > mj2)
			return 1;
		if (mj1 < mj2)
			return -1;
		if (mj1 == mj2 && mn1 != mn2)
			return (mn1 > mn2) ? 1 : -1;
		if (mj1 == mj2 && mn1 == mn2)
			return 0;
		return -1;

	}

	public static String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";
		String[] words = s.split(" ");
		if (words.length == 0)
			return "";

		int start = 0;
		int end = words.length - 1;
		while (start < end) {
			String temp;
			temp = words[start];
			words[start] = words[end];
			words[end] = temp;
			end--;
			start++;
		}

		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			if (word.length() != 0) {
				sb.append(word);
				sb.append(" ");
			}
		}
		String finalString = sb.toString();
		return finalString.substring(0, finalString.length() - 1).trim();
	}
	

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int value = nums[0];
        int count=1;
        for(int i=1 ;i<nums.length ;i++)
            {
               if(nums[i]==value && count==2)
                {
                    nums[i]=-1;
                    continue;
                }
                if(nums[i]==value && count==1)
                {
                    count++;
                }
                if(nums[i]!=value)
                {
                    value = nums[i];
                    count=1;
                }
            }
       count=0;
       for(int i=0 ;i<nums.length ; i++)
        {
            if(nums[i]!=-1)
                nums[count++]=nums[i];
        }
     return count;   
    }


}
