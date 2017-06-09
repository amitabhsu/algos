package com.r1.testjava8;

public class CheckIfNumberisPalindrome {

	public static void main(String[] args) {
		boolean flag = isPalindrome(1);
		System.out.println(flag);

	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int y = x;
		int rev = 0;
		while (x > 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return y == rev;
	}

}
