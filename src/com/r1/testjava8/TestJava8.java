package com.r1.testjava8;
public class TestJava8 {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("Hello Java 8!")).start();
	}
}