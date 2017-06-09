package com.r1.linkedlist;

import java.util.PriorityQueue;

public class MyStack {
	static PriorityQueue<Integer> inbox = new PriorityQueue<>();
	static PriorityQueue<Integer> outbox = new PriorityQueue<>();

	// Push element x onto stack.
	public static void push(int x) {
		inbox.add(x);
	}

	// Removes the element on top of the stack.
	public static void pop() {
		while (inbox.size() != 1) {
			outbox.offer(inbox.poll());
		}
		System.out.println(inbox.poll());
		while (!outbox.isEmpty()) {
			inbox.offer(outbox.poll());
		}
		// return value;

	}

	// Get the top element.
	public static int top() {
		if (inbox.isEmpty())
			return Integer.MAX_VALUE;
		while (inbox.size() != 1) {
			outbox.offer(inbox.poll());
		}
		int value = inbox.peek();
		//outbox.add(value);
		while (!outbox.isEmpty()) {
			inbox.offer(outbox.poll());
		}
		return value;
	}

	// Return whether the stack is empty.
	public static boolean empty() {
		return (inbox.size() == 0);

	}

	public static void main(String[] args) {
		push(1);
		push(2);
		System.out.println(top());
		pop();
		pop();
		System.out.println(empty());
	}
}