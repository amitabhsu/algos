package com.r1.stacks;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println("Original stack");
		System.out.println(s);
		// Original stack
		// [4, 3, 2, 1] 1 is top
		reverse(s);
		System.out.println("Reversed stack");
		System.out.println(s);
	}

	public static void reverse(Stack<Integer> s) {
		if (s.isEmpty()) {
			return;
		}
		int pop = s.pop();
		reverse(s);
		System.out.println("Before insert");
		System.out.println(pop);
		System.out.println();
		insert(s, pop);
		System.out.println();
	}

	public static void insert(Stack<Integer> s, int popped) {
		if (s.isEmpty()) {
			s.push(popped);
		} else {
			int element = s.pop();
			insert(s, popped);
			s.push(element);
		}
	}
}