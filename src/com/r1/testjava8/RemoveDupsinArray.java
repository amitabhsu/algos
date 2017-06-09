package com.r1.testjava8;

//LeetCode #80
//Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

public class RemoveDupsinArray {

	public static void main(String[] args) {
		//int[] a = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 3 };
		int []a = {1,1,1,2,2,2,2,2,3};
		removeDups(a);
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != -1)
				a[cnt++] = a[i];
		}
		while (cnt < a.length)
			a[cnt++] = 0;
		System.out.println("After pruning.......");
		for (int x : a)
			System.out.println(x);

	}

	private static void removeDups(int[] a) {
		int lastUniqueIdx = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[lastUniqueIdx] == a[i]) {
				if (count > 1) {
					a[i] = -1;
				} else
					count++;
			} else {
				lastUniqueIdx = i;
				i--;
				count = 0;
			}
		}

	}

}
