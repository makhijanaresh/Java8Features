package com.java8.features.other.improvements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CollectionAPIImprovements {

	public static void main(String[] args) {
//		List<Integer> listOfInteger=IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		// listOfInteger.stream().forEach(System.out::println);

		Map<String, String> map = new HashMap<>();
		map.putIfAbsent("C", "c");
		map.put("B", "b");
		map.put("Z", "z");
		map.putIfAbsent("C", "latest vaue");
		map.forEach((k, v) -> System.out.println("Key:" + k + ",value:" + v));

		System.out.println(map.get("C"));
		System.out.println(map.getOrDefault("A", "Default value"));
		map.forEach((k, v) -> System.out.println("Key:" + k + ",value:" + v));

		List<Integer> coll = new ArrayList();
		coll.add(5);
		coll.add(9);

		Predicate<Integer> predicate = (x) -> x < 1;
		coll.forEach(System.err::println);
		coll.removeIf(predicate);
		coll.forEach(System.out::println);

	}

}
