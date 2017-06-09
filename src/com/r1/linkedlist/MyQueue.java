package com.r1.linkedlist;

import java.util.Stack;

public class MyQueue {
	// Push element x to the back of queue.
	static Stack<Integer> inbox = new Stack<>();
	static Stack<Integer> outbox = new Stack<>();

	public static void push(int x) {
		inbox.push(x);
	}

	// Removes the element from in front of queue.
	public static void pop() {
		if (inbox.isEmpty())
			return;
		while (inbox.size() != 1) {
			outbox.push(inbox.pop());
		}
		inbox.pop();
		while (!outbox.isEmpty())
			inbox.push(outbox.pop());
	}

	// Get the front element.
	public static int peek() {
		if (inbox.isEmpty())
			return -1;
		while (inbox.size() != 1) {
			outbox.push(inbox.pop());
		}
		int value = inbox.peek();
		while (!outbox.isEmpty())
			inbox.push(outbox.pop());
		return value;
	}

	// Return whether the queue is empty.
	public static boolean empty() {
		return (inbox.size() == 0);

	}

	public static void main(String[] args) {
		push(1);
		push(2);
		System.out.println(peek());
		System.out.println(peek());

	}
}