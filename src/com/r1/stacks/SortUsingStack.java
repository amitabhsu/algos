package com.r1.stacks;

public class SortUsingStack {
	int max;
	int top;
	static int a[];

	SortUsingStack(int size) {
		max = size;
		top = -1;
		a = new int[10];

	}

	public static void main(String args[]) {

		SortUsingStack st = new SortUsingStack(10);
		st.fillStack();
		System.out.println("before sorting");
		st.print();
		st.sorts(a);
		System.out.println("After sorting");
		st.print();

	}

	private void sorts(int[] a) {
		int pop = 0;
		if (top != -1) {
			pop = pop();
			sorts(a);
			insert(a, pop);
		}

	}

	private void insert(int[] a, int pop) {
		if (top == -1) {
			push(pop);
		} else {
			if (pop > peek()) {
				int c = pop();
				insert(a, pop);
				push(c);
			} else {
				push(pop);
			}
		}
	}

	private int peek() {
		int b = a[top];
		return b;
	}

	private int pop() {
		int b = a[top];
		top = top - 1;
		return b;
	}

	private void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "-->");
		}
		System.out.println("Top");
	}

	private void fillStack() {
		for (int i = 0; i < a.length; i++) {
			push((int) (Math.random() * 100));
		}
	}

	private void push(int i) {
		a[++top] = i;
	}
}
