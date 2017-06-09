package com.r1.testjava8;

import java.util.ArrayList;

public class CountandSay {

	public static void main(String[] args) {
		int n = 5;
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("1");
		int count = 1;
		while (count <= n) {
			String s = "1211";
			s=list.get(count);
			char x = s.charAt(0);
			StringBuilder sb = new StringBuilder();
			int i = 0;
			while (i < s.length()) {
				int num = 0;
				while (i < s.length() && x == s.charAt(i)) {
					num++;
					i++;
				}
				sb.append(String.valueOf(num)).append(x);
				if (i < s.length())
					x = s.charAt(i);
			}
			list.add(sb.toString());
			System.out.println(sb.toString());
			count++;
		}
		System.out.println(".....");
	}
	

}
