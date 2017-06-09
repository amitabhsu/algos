package com.r1.testjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagrams.groupAnagrams(strs);

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> finalList = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> hM = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			String s = new String(ca);
			if (hM.containsKey(s)) {
				hM.get(s).add(str);

			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				hM.put(s, list);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : hM.entrySet()) {
		    Object value = entry.getValue();
		    finalList.add((ArrayList<String>)value);
		}

		return finalList;

	}

}
