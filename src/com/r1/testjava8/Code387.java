package com.r1.testjava8;

import java.util.LinkedHashMap;
import java.util.Map;

public class Code387 {

	public static void main(String[] args) {
		int x = firstUniqChar("loveleetcode");
		System.out.println(x);
	}

	public static int firstUniqChar(String s) {
		char val = '.';
		int idx = -1;
		if (s == null || s.length() == 0)
			return -1;
		if (s.length() == 1)
			return 0;
		char[] a = s.toCharArray();
		LinkedHashMap<Character, Integer> set = new LinkedHashMap<>();
		for (char c : a) {
			if (set.containsKey(c)) {
				// int cnt = set.get(c);
				set.put(c, set.get(c) + 1);
			} else
				set.put(c, 1);
		}
		for (Map.Entry<Character, Integer> e : set.entrySet()) {
			if (e.getValue() == 1) {
				val = e.getKey();
				break;
			}
		}
		for (int x = 0; x < a.length; x++) {
			if (a[x] == val) {
				idx = x;
				break;
			}
		}
		return idx;
	}

}
