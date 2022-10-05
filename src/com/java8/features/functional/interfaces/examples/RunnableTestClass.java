package com.java8.features.functional.interfaces.examples;

public class RunnableTestClass {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			System.out.println("Test");
			System.out.println("Hello world");
		};
		
		
		Thread t1 = new Thread(r1);
		t1.start();

		/*
		 * TestFunctionalInterface tfi = (x, y) -> x + y;
		 * 
		 * Integer result = tfi.testMethod(5, 17); System.out.println(result);
		 */

	}
}
