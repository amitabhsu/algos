package com.r1.testjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] S = { -1, 2, 1, 4 };
		reverseBits(43261596);

	}

	public static int reverseBits(int n) {
		long result = 0;
		String x = Integer.toBinaryString(n);
		String bs = String.format("%32d", Integer.valueOf(x));
		System.out.println(bs.length());
		char[] array = bs.toCharArray();
		for (int i = 0; i < array.length; i++) {
			result = result * 2 + (array[i] - '0');

		}
		return (int) result;
	}

}
