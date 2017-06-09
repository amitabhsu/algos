package com.r1.testjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsTogether {

	public static String getAnagramsTogether(String sentence) {

		if (sentence == null || sentence.trim().equals(""))
			return null;

		String[] words = sentence.split(" ");
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String word : words) {
			char[] wordArray = word.toCharArray();
			Arrays.sort(wordArray);

			List<String> tempList = map.get(new String(wordArray));
			if (tempList == null)
				tempList = new ArrayList<String>();
			tempList.add(word);
			map.put(new String(wordArray), tempList);
		}

		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			for (String item : entry.getValue()) {
				result.append(item + " ");
			}
		}

		return result.toString();
	}
}
