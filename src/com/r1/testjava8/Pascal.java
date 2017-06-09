package com.r1.testjava8;

import java.util.*;

public class Pascal {
	static List<List<Integer>> finalList = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int numRows = 5;
		finalList = generate(numRows);
		for (List<Integer> list : finalList) {
			System.out.println("Start new list...");
			for (Integer i : list) {
				System.out.println(i);
			}
		}
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return finalList;
		List<Integer> l = new ArrayList<>();
		l.add(1);
		finalList.add(l);
		if (numRows == 1)
			return finalList;
		List<Integer> m = new ArrayList<>();
		m.add(1);
		m.add(1);
		finalList.add(m);
		if (numRows == 2)
			return finalList;
		for (int i = 2; i < numRows; i++) {
			List<Integer> prevList = finalList.get(i - 1);
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			for (int j = 1; j < i; j++) {
				temp.add(j, prevList.get(j - 1) + prevList.get(j));
			}
			temp.add(1);
			finalList.add(temp);

		}

		return finalList;
	}

}
