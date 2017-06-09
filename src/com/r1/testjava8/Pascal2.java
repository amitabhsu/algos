package com.r1.testjava8;

import java.util.*;

public class Pascal2 {

	static List<Integer> finalList = new ArrayList<>();

	public static void main(String[] args) {
		int numRows = 3;
		finalList = generate(numRows);
		for (Integer i : finalList) {
			System.out.println(i);
		}
	}

	public static List<Integer> generate(int numRows) {
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<>();
		l.add(1);
		finalList.add(l);
		if (numRows == 0)
			return finalList.get(0);
		List<Integer> m = new ArrayList<>();
		m.add(1);
		m.add(1);
		finalList.add(m);
		if (numRows == 1)
			return finalList.get(1);
		for (int i = 2; i <=numRows; i++) {
			List<Integer> prevList = finalList.get(i - 1);
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			for (int j = 1; j < i; j++) {
				temp.add(j, prevList.get(j - 1) + prevList.get(j));
			}
			temp.add(1);
			finalList.add(temp);

		}

		return finalList.get(numRows);
	}

}
