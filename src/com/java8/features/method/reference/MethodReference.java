package com.java8.features.method.reference;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		// TestInterface response=TestClass::testMethod;
		// response.testInterfaceMethod();

		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		
		list.stream().map(element->element.toUpperCase());
		list.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}

/**
 * class TestClass { public static String testMethod() {
 * System.out.println("Test method invoked"); return "hello world"; } }
 * interface TestInterface { void testInterfaceMethod(); }
 */
