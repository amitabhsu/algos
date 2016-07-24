package com.r1.linkedlist;

public class WildCardMatching {
	
/*	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
	
	https://leetcode.com/problems/wildcard-matching/
	Solution : http://n00tc0d3r.blogspot.com/2013/05/wildcard-matching.html
	*/

	public static void main(String[] args) {
		boolean flag = WildCardMatching.isMatch("aab", "*a*b");
		System.out.println(flag);

	}

	public static boolean isMatch(String s, String p) {  
		   if (s == null || p == null) 
			   return false;  
		   if (p.isEmpty()) 
			   return s.isEmpty();  
		     
		   // '*'  
		   if (p.charAt(0) == '*') {  
		     // skip duplicate '*'  
		     int nonstar = 0;  
		     while (nonstar < p.length() && p.charAt(nonstar) == '*') 
		    	 ++nonstar;  
		     int index = 0;  
		     while (index <= s.length()) {  
		       if (isMatch(s.substring(index), p.substring(nonstar)))  
		         return true;  
		       ++index;  
		     }  
		   } else {  
		     // single char match  
		     if (!s.isEmpty() &&  (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')) {  
		       return isMatch(s.substring(1), p.substring(1));  
		     }  
		   }  		   
		   // no match  
		   return false;  
		 }  


}
