package com.r1.testjava8;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(2);
		repeatedNumber(a);
	}
	public static ArrayList<Integer> repeatedNumber( List<Integer> a) {
	    int sqA=0;
	    int sumA=0;
	    int sqN=0;
	    int sumN=0;
	    for(Integer i : a)
	        {
	            sqA+=i*i;
	            sumA+=i;
	        }
	   for(int i=1 ; i <=a.size() ; i++)
	        {
	            sqN+=i*i;
	            sumN+=i;
	        }
	   int diff = sumN-sumA;
	   int sqDiff = sqN-sqA;
	   diff=Math.abs(diff);
	   sqDiff=Math.abs(sqDiff);
	   System.out.println(diff);
	   System.out.println(sqDiff);
	   int sum = sqDiff/diff;
	   ArrayList<Integer> rs = new ArrayList<>();
	   rs.add(Math.abs((diff+sum)/2));
	   rs.add(Math.abs((diff-sum)/2));
	   return rs ;
	}
}