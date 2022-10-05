package com.java8.features.streams;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class IntStreamExamples {

	public static void main(String[] args) {
	//	IntStream.range(3, 9).forEach(System.out::println);
		
		//System.err.println("---------------");
//
		//IntStream.rangeClosed(1, 9).forEach(System.err::println);
		//System.err.println("----------------------");

		Supplier<IntStream> streamSupplier = () -> IntStream.of(1, 2, 3, 4, 5);

	//	System.out.println("Average:" + streamSupplier.get().average());
	//	System.out.println("Sum:" + streamSupplier.get().sum());

		IntPredicate isEven = argument -> argument % 2 == 0;

		// takeWhile and dropWhile are introduced in java9
		//System.out.println("Before takeWhile");
		//IntStream.of(10,1, 2, 4, 9, 7, 3, 5, 4, 8).takeWhile(isEven).forEach(System.out::println);
		// once it gets false then it by-pass rest of the recrods and same for dropwhile

		System.out.println("After takeWhile");
		IntStream.of(10,3,6,8,1, 2, 4, 9, 7, 3, 5, 4, 8).dropWhile(isEven).forEach(System.out::println);// introduced in Java9

		// reduce example 1

		OptionalInt resultOne = IntStream.of(1, 2, 3, 4, 5).reduce((a, b) -> a + b);
		
		System.err.println("ResultOne:" + resultOne.getAsInt());

		// reduce example 2
		int result = IntStream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> 2 * a + 3 * b);
		System.err.println("Result:" + result);

	}
}
