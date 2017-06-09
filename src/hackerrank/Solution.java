package hackerrank;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public static void main(String args[]) throws Exception {
		int numOfTestCases = -1;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<ArrayList<String>> inputLines = new ArrayList<ArrayList<String>>();
		while ((line = stdin.readLine()) != null && line.length() != 0) {
			String[] input = line.split(" ");
			System.out.println(input[0]);

			ArrayList<String> chars = new ArrayList<>(Arrays.asList(input));

			inputLines.add(chars);
		}
		System.out.println(inputLines);
		numOfTestCases = Integer.valueOf(inputLines.get(0).get(0));
		String pattern = "^[a-zA-Z]*$";
		HashMap<String, String> results = new HashMap<>();
		for (int i = 1; i < inputLines.size(); i++) {
			ArrayList<Integer> nums = new ArrayList<>();
			for (String s : inputLines.get(i)) {
				if (s.matches(pattern)) {
					String value = "WRONG INPUT LINE" + i;
					results.put("FAILURE", value);
					break;
				} else {
					nums.add(Integer.valueOf(s));
				}
				Collections.sort(nums);
				if (!(numOfTestCases == nums.get(nums.size() - 1))) {
					String value = "RECEIVED:" + nums.get(nums.size() - 1) + "EXPECETED :" + numOfTestCases;
					results.put("FAILURE", value);
					break;
				}
				String value = "RECEIVED:" + numOfTestCases;
				results.put("SUCCESS", value);
			}
		}
		for (Entry<String, String> entry : results.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}