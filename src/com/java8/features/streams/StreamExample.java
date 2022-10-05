package com.java8.features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		List<Employee> employees = generateEmployeeList();

		List<String> multipleUseList = Arrays.asList("Pavan", "Ajay", "Bhavesh", "Rakesh", "Amar", "Rames", "ajay");

		// filterMapAndCollectExample(employees);
		// mapToIntExample();
		// sortExample(employees, multipleUseList);
		// peekExample(multipleUseList);
		//anyMatchAllMatchNoneMatchExample(employees);
		listToMapConversionExamples(employees);
	}

	private static void flatMapExample() {
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		List<String> collect = Stream.of(array).flatMap(Stream::of).filter(x -> !"a".equals(x))
				.collect(Collectors.toList());

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8, 9);

		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
		List<Integer> listOfAllIntegers = listOfLists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());

		System.out.println(listOfAllIntegers);
	}

	private static void listToMapConversionExamples(List<Employee> employees) {
		System.out.println("Employees:" + employees);

		// below code is to ger Map<Integer,List<Employee>>

	//	Map<Integer, List<Employee>> mapOfList = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
	//	mapOfList.forEach((k, v) -> System.out.println("---key:" + k + ", ---value:" + v));

		Map<Integer, String> map;
		// map= employees.stream().collect(Collectors.toMap(Employee::getSalary,
		// Employee::getName));
		// System.out.println("FirstTry:" + map);

		map = employees.stream()
				.collect(Collectors.toMap(Employee::getSalary, Employee::getName,(oldValue, newValue) -> oldValue));
		//System.out.println("Second Try:" + map);

	//	List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		//Map<String, Long> mapResult = items.stream()
		//		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		//System.out.println("Count Result:" + mapResult);

	//	Map<Integer, IntSummaryStatistics> testMap = employees.stream()
	//			.collect(Collectors.groupingBy(Employee::getAge, Collectors.summarizingInt(Employee::getSalary)));
	//	testMap.forEach((k, v) -> System.out.println("key:" + k + ",value:"+v));

		// we dont' want whole object we want a specific column list/set
	//	Map<Integer, Set<String>> mappingMap = employees.stream().collect(
		//		Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toSet())));
		//mappingMap.forEach((k, v) -> System.out.println("key:" + k + ",value:"+v));

		Map<Boolean, List<String>> booleanMappingMap = employees.stream().collect(Collectors
				.partitioningBy(emp -> emp.getAge() > 27, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		System.out.println(booleanMappingMap);

	}

	private static List<Employee> generateEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee(1, "Ramesh", 30, 30400);
		Employee e2 = new Employee(2, "Suresh", 29, 20888);
		Employee e3 = new Employee(3, "Ajay", 27, 40000);
		Employee e4 = new Employee(4, "Aman", 15, 15000);
		Employee e5 = new Employee(5, "rajesh", 14, 10000);
		Employee e6 = new Employee(6, "Ram", 29, 10000);
		Employee e7 = new Employee(7, "Rahul", 27, 20000);
		Employee e8 = new Employee(1, "Ramesh", 31, 35000);
		Employee e9 = new Employee(1, "Ramesh", 31, 16000);
		Employee e10=new Employee(12,"Rajat",15,100000);

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.add(e6);
		employees.add(e7);
		employees.add(e8);
		employees.add(e9);
		employees.add(e10);

		return employees;

	}

	private static void anyMatchAllMatchNoneMatchExample(List<Employee> employees) {
		Predicate<String> nameStartsWithA = (name) -> name.toUpperCase().startsWith("A");

		Predicate<Integer> olderThan15 = (age) -> age >= 15;

		Predicate<String> nameStartsWithZ = (name) -> name.toUpperCase().startsWith("Z");

		Boolean result = employees.stream().map(Employee::getName).anyMatch(nameStartsWithZ);
		// System.out.println("AnyMatch:" + result);

		/*
		 * result = employees.stream().map(Employee::getName).allMatch(nameStartsWithZ);
		 * System.out.println("All Match:" + result);
		 */

		result = employees.stream().map(Employee::getName).noneMatch(nameStartsWithZ);
		System.out.println("None match :" + result);
		// System.out.println("All Match age>15:" + result);
		

		result = employees.stream().map(Employee::getAge).noneMatch(olderThan15);
		System.out.println("None Match with A:" + result);

		
	//	result = employees.stream().map(Employee::getName).noneMatch(nameStartsWithZ);
	//	System.out.println("None Match with Z:" + result);

	}

	private static void peekExample(List<String> multipleUseList) {
		multipleUseList.stream().peek(System.out::println);
		multipleUseList.stream().peek(System.out::println).isParallel();

		System.out.println("----------");
		multipleUseList.stream().peek(str -> System.out.println("str:" + str)).filter(x -> !x.isEmpty())
				.map(String::toUpperCase).peek(System.out::println);
		System.out.println("+++++++++++");

		multipleUseList.stream().peek(str -> System.out.println("str:" + str)).filter(x -> !x.isEmpty())
				.map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList());

	}

	private static void sortExample(List<Employee> employees, List<String> multipleUseList) {
		// System.out.println("Before sort");
		// //multipleUseList.stream().sorted().forEach(System.out::println);
		// System.out.println("After sort");

		// case sensitive comparision
		// multipleUseList.stream().sorted((String s1, String s2) ->
		// s2.compareTo(s1)).forEach(System.out::println);
		// same example with no type definition

		// System.out.println("Before case ignore");

		// multipleUseList.stream().sorted((s1, s2) ->
		// s1.compareToIgnoreCase(s2)).forEach(System.out::println);

		System.out.println("Multiple Comparing example");
		Comparator<Employee> comparatorEmployee = Comparator.comparing(Employee::getSalary)
				.thenComparing(Employee::getName);

		Collections.sort(employees, comparatorEmployee);

		employees.forEach(System.out::println);
	}

	private static void mapToIntExample() {
		List<String> intList = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

		intList.stream().map(a -> Integer.parseInt(a)).collect(Collectors.toList());

		List<Integer> list = intList.stream().mapToInt(Integer::parseInt).collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);

		list.forEach(System.err::println);
	}

	private static void filterMapAndCollectExample(List<Employee> employees) {
		// filter example with predicate

		Predicate<Employee> salaryPredicate = (empSalary) -> empSalary.getSalary() > 15000;

		List<Employee> filteredEmployees = employees.stream().filter(salaryPredicate).collect(Collectors.toList());

		// getting object of employee whose salary is greater than 15000

		Consumer<Employee> consumer = (e) -> System.out.println(e);

		filteredEmployees.forEach(consumer);

		// map example, here we will take all the name of employees in upper case and
		// will return list of names instead of whole object here and
		// we are providing Function interface in map which will take one parameter

		Function<Employee, String> function = (e) -> e.getName();

		Stream<String> streamOfEmployeeNames = employees.stream().map(e -> e.getName()).map(String::toUpperCase);

		// streamOfEmployeeNames.forEach(System.out::println);

		// combination of filter,map and collect method

		// Map<String,Integer>
		// collectMapExample=employees.stream().filter(emp->emp.getSalary()>10).map(Employee::getName)
		// .collect(Collectors.toMap(Function.identity(),
		// String::length,(oldValue,newValue)->oldValue));

		// after length just add this ,(oldValue,newValue)->oldValue

		// collectMapExample=employees.stream().filter(emp->emp.getSalary()>15000)
		// .map(Employee::getName).collect(Collectors.toMap(Function.identity(),
		// String::length));

		// System.out.println("length:"+collectMapExample.size());
		// collectMapExample.forEach((k,v)->System.out.println("key:"+k+",value:"+v));
	}

}
