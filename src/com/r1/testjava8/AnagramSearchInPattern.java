package com.r1.testjava8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AnagramSearchInPattern {

	public static void main(String[] args) {
		List<Integer> rs = new ArrayList<>();
		rs = findSubstring("BACDGABCDA", "ABCD");
		for (int i = 0; i < rs.size(); i++)
			System.out.println(rs.get(i));

	}

	public static List<Integer> findSubstring(String str, String ptn) {
		List<Integer> res = new LinkedList<Integer>();
		int[] pntcnt = new int[256];
		int[] strcnt = new int[256];
		for (int i = 0; i < ptn.length(); i++) {
			pntcnt[ptn.charAt(i)]++;
		}
		int i = 0;
		for (i = 0; i < ptn.length() && i < str.length(); i++) {
			strcnt[str.charAt(i)]++;
		}
		if (isSame(pntcnt, strcnt)) {
			res.add(i - ptn.length());
		}
		while (i < str.length()) {
			strcnt[str.charAt(i)]++;
			strcnt[str.charAt(i - ptn.length())]--;
			i++;
			if (isSame(pntcnt, strcnt)) {
				res.add(i - ptn.length());
			}
		}
		return res;
	}

	public static boolean isSame(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length)
			return false;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

}
