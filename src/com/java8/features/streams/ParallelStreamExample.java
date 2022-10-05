package com.java8.features.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		ParallelStreamExample example = new ParallelStreamExample();
		example.test();
	}

	private void test() {
		Consumer<Integer> consumer = (it) -> {
			System.out.println("Wait start for thread:" + Thread.currentThread().getName() + " int number:" + it);
			try {
				Thread.sleep(5000);

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.err.println("Wait ends for thread:" + Thread.currentThread().getName() + " int number:" + it);
		};

		List<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");

		
		list.parallelStream().forEach(consumer);

	}
}
