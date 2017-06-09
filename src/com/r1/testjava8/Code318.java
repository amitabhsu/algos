package com.r1.testjava8;

import java.util.HashSet;

public class Code318 {

	public static void main(String[] args) {
		String[] arr = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		System.out.println(maxProduct(arr));

	}

	public static int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		if (words.length == 1)
			return 0;
		int maxProd = 0;
		for (int i = 0; i < words.length; i++) {
			char[] w1 = words[i].toCharArray();
			HashSet<Character> hs1 = new HashSet<>();
			for (char c : w1)
				hs1.add(c);
			for (int j = i + 1; j < words.length; j++) {
				char[] w2 = words[j].toCharArray();
				HashSet<Character> hs2 = new HashSet<>();
				for (char c : w2)
					hs2.add(c);
				HashSet<Character> newSet = new HashSet<Character>(hs1);
				//HashSet<Character> res = new HashSet<Character>();
				newSet.removeAll(hs2);
				if (hs1.size() != newSet.size())
					continue;
				// System.out.println(words[i] +" "+words[j]);
				// System.out.println((words[i].length())*(words[j].length()));
				// System.out.println("\n");
				maxProd = Math.max((words[i].length()) * (words[j].length()), maxProd);
			}
		}
		return maxProd;
	}

}
