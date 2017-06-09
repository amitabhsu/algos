package com.r1.testjava8;

import java.util.ArrayList;

public class HappyNumber {

	public static void main(String[] args) {
		boolean value = HappyNumber.isHappy(11);
		System.out.println(value);

	}

	public static boolean isHappy(int n) {
		if (n == 1)
			return true;
		if (n == 2)
			return false;
		if (n == 3)
			return false;
		ArrayList<Integer> list = new ArrayList<>();
		while (n > 0) {
			if (n == 1)
				return true;
			if(n ==2 || n ==3)
				return false;
			while (n > 0) {
				list.add(n % 10);
				n = n / 10;
			}
			n = 0;
			for (int num : list)
				n += num * num;
			list = new ArrayList<>();
		}
		return false;
	}

}
