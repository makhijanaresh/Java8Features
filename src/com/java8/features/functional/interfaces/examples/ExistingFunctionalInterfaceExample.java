package com.java8.features.functional.interfaces.examples;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.java8.features.streams.Employee;

public class ExistingFunctionalInterfaceExample {

	public static void main(String[] args) {
		// predicateExample();

		//suppliersExample();
		 functionaInterfaceExample();
		// consumerInterfaceExample();

	}

	private static void consumerInterfaceExample() {
		List<String> list = new ArrayList<>();

		Consumer<String> consumer = (x) -> {
			list.add(x);
		};

		consumer.accept("Hello");
		consumer.accept("World!");
		System.out.println("Consume:" + list);

		/*
		 * for(String str:list) { System.out.println(str); }
		 */

		list.forEach(str -> System.out.println(str));
	}

	private static void functionaInterfaceExample() {
		Function<String, Integer> function = (x) -> Integer.parseInt(x);

		System.out.println(function.apply("10"));

		// before function interface
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		System.out.println("before:" + value);

		// after function interface
		value = nameMap.computeIfAbsent("11", function);
		System.out.println("after:" + value);
	}

	private static void suppliersExample() {

		Supplier<LocalDateTime> dateTime = () -> LocalDateTime.now();

		System.out.println(dateTime.get());

		Employee emp = new Employee();

		Supplier<Integer> age = emp::getAge;
		
		age.get();

		Supplier<Date> date = () -> new Date();
		

		System.out.println(dateTime.get());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void solutionWithSupplier(List<String> list) {
		System.out.println("Solution method invoked");
		Supplier<Stream<String>> streamSupplier = () -> list.stream();
		Stream<String> stream1 = streamSupplier.get();
		Stream<String> stream2 = streamSupplier.get();
		System.out.println("supplier get 1:" + stream1);
		System.out.println("Supplier get 2:" + stream2);
	}

	/*
	 * IN this case we want to use same stream again, but clearly we can see we can
	 * read stream once
	 */

	private static void problemBeforeSupplier(List<String> list) {
		Stream<String> stream = list.stream();

		stream.forEach(element -> System.out.println(element));

		System.out.println("============");
		stream.forEach(System.out::println);
	}

	/*
	 * In this example we are creating stream again
	 */
	private static void wrongSolution(List<String> list) {
		Stream<String> stream1 = list.stream();
		stream1.forEach(System.out::println);
		// stream1.forEach(System.out::println);

		Stream<String> stream2 = list.stream();

		stream2.forEach(System.out::println);
		// stream2.forEach(System.out::println);
	}

	/**
	 * when we want to perform one operation and want to get result in true or false
	 * then we can use Predicate interface
	 */

	private static void predicateExample() {
		Predicate<Integer> predicate = (x) -> x < 5;
		Predicate<Integer> predicate2 = (x) -> x < 3;

		Integer number = 10;
		System.out.println("Number:" + number + " is equal to 5 : " + predicate.test(number));
		number = 5;
		System.out.println("Numer:" + number + " is equal to 5 : " + predicate.test(number));

		System.out.println(predicate.and(predicate2).test(4));
		System.out.println(predicate.or(predicate2).test(9));

		Predicate<Integer> negatePredicate = predicate.negate();
		System.out.println("Negate:" + negatePredicate.test(4));

		Predicate<String> pred = Predicate.isEqual("abd");

		System.out.println("IsEquals Example:" + pred.test("abd"));

	}

}
