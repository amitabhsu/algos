package com.r1.testjava8;

public class AddBinaryNumbers {

	public static void main(String[] args) {
		String s = addBinary("111", "1");
		System.out.println(s);

	}

	public static String addBinary(String a, String b) {
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		int aL = a.length();
		int bL = b.length();
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.max(aL, bL); i++) {
			int sum = 0;
			if (i < aL)
				sum += (int) ((a.charAt(i)) - '0');
			if (i < bL)
				sum += (int) ((b.charAt(i)) - '0');
			sum += carry;
			if (sum == 3) {
				carry = 1;
				sb.append('1');
			} 
			else if (sum == 2) {
				sb.append('0');
				carry = 1;
			}else if (sum == 1) {
				sb.append('1');
				carry = 0;
			} else {
				sb.append('0');
				carry = 0;
			}
		}
		if (carry == 1)
			sb.append('1');
		return sb.reverse().toString();
	}
}
