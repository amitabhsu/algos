package com.r1.testjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    static HashMap<Character, List<Character>> hM = new HashMap<Character, List<Character>>();
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        hM.put('2', Arrays.asList('a', 'b', 'c'));
		hM.put('3', Arrays.asList('d', 'e', 'f'));
		hM.put('4', Arrays.asList('g', 'h', 'i'));
		hM.put('5', Arrays.asList('j', 'k', 'l'));
		hM.put('6', Arrays.asList('m', 'n', 'o'));
		hM.put('7', Arrays.asList('p', 'q', 'r','s'));
		hM.put('8', Arrays.asList('t', 'u', 'v'));
		hM.put('9', Arrays.asList('w', 'x','y','z'));
		helper(digits, res, new StringBuffer(), 0);
		return res;
        
    }
    
    public static void helper(String s, List<String> res, StringBuffer code, int pos) {
		if (s == null || s.length() == 0)
			return;
		if (pos>= s.length()) {
			res.add(code.toString());
			return;
		}

		Character c = s.charAt(pos);
		for (Character neighbour : hM.get(c)) {
			code.append(neighbour);
			helper(s, res, code, pos + 1);
			code.deleteCharAt(code.length() - 1);
		}
	}
}