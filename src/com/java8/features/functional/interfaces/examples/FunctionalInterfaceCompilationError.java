package com.java8.features.functional.interfaces.examples;

@FunctionalInterface
public interface FunctionalInterfaceCompilationError {

	public Integer test(int x);
	
	//public Integer test2(); uncomment this
	
	//can't have two declared method in an interface if it's annotated with
	//@FunctionalInterface annotation(Contract set by Java)
	
}
