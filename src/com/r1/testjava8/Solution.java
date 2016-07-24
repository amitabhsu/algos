package com.r1.testjava8;

public class Solution {

	public static void main(String[] args) {
		int value = Solution.divide(-1, -1);
		System.out.println(value);
	}

	public static int divide(int dividend, int divisor) {
		boolean flag = false;
		if ((divisor < 0 || dividend < 0) && !(divisor < 0 && dividend < 0)) {
			flag = true;
			if (divisor < 0)
				divisor = 0 - divisor;
			if (dividend < 0)
				dividend = 0 - dividend;
		}
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;
		if (dividend < divisor)
			return 0;
		int q = 0;
		if (dividend == divisor)
			return flag ? (0 - 1) : 1;
		while (dividend > divisor) {
			dividend = -divisor;
			q++;
		}
		return flag ? (0 - q) : q;
	}
}
