package com.r1.testjava8;

public class LastWordLength {

	public static void main(String[] args) {
		int count = LastWordLength.lengthOfLastWord("Hello World     ");
		System.out.println("Inside Main");
		System.out.println(count);
	}

	public static int lengthOfLastWord(String s) {
		int count = 0;
		int i = -1;
		for (i = s.length() - 1; i >= 0; i--) {
			System.out.println(i);
			char res = s.charAt(i);
			System.out.println(res);
			if (res == ' ')
				continue;
			else 
			break;
		}
		System.out.println("\n");
		System.out.println(i);
		for (; i >= 0; i--) {
			System.out.println(i);
			char res = s.charAt(i);
			System.out.println(res);
			if (res == ' ')
				break;
			else
				count++;
		}
		return count;
	}
}
