package com.rajeshanthari.udemy.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBysalary {

	public static void main(String[] args) {

		Department cse = new Department(501, "CSE");
		Department ece = new Department(502, "ECE");
		Department civ = new Department(503, "CIV");

		Employee employee = new Employee(101, "Rajesh", "Anthari", cse, 5000);
		Employee employee2 = new Employee(102, "RShiva", "B", cse, 4500);
		Employee employee3 = new Employee(103, "Pavindar", "B", cse, 4500);
		Employee employee4 = new Employee(104, "Bhagya", "M", cse, 10000);
		Employee employee5 = new Employee(111, "BOlaf", "s", ece, 150000);
		Employee employee6 = new Employee(112, "BMark", "B", ece, 160000);
		Employee employee7 = new Employee(113, "BMuhi", "M", ece, 1550000);
		Employee employee8 = new Employee(121, "Guru", "P", civ, 162450);
		Employee employee9 = new Employee(122, "Prahlad", "M", civ, 175225);
		Employee employee10 = new Employee(123, "Arvind", "P", civ, 98552);
		Employee employee11 = new Employee(124, "Nachin", "S", civ, 98554);
		List<Employee> employees = Arrays.asList(employee, employee2, employee3, employee4, employee5, employee6,
				employee7, employee8, employee9, employee10, employee11);

		employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))))
				.forEach((k, v) -> System.out.println(k + " --> " + v.get().getSalary()));

		Map<Integer, String> collect = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getFirstName));
		collect.forEach((k, v) -> {
			System.out.println(k + " --> " + v);
		});

		// employees.stream().filter( emp -> emp.getSalary() > 70000 &&
		// emp.getFirstName().startsWith("a")).sorted((e1, e2) ->
		// e1.getFirstName().compareTo(e2.getFirstName())).collect(Collectors.toList());

//		Map<Department, List<Employee>> collect = employees.stream()
//				.collect(Collectors.groupingBy(Employee::getDepartment));
//		
//		collect.forEach((k, v) -> System.out.println(k + " = " + v));
//		
//		Map<Department, Optional<Employee>> collect2 = employees.stream().collect(Collectors.groupingByConcurrent(
//				Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
//		
//		collect2.forEach((k, v) -> System.out.println(k + " = " + v.get().getSalary()));
//		
//		ConcurrentMap<Department, Employee> collect3 = employees.stream()
//				.collect(Collectors.groupingByConcurrent(Employee::getDepartment, Collectors.collectingAndThen(
//						Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
//		collect3.forEach((k, v) -> System.out.println(k + " = " + v.getSalary()));
//
//		ConcurrentMap<Department, Double> collect4 = employees.stream().collect(
//				Collectors.groupingByConcurrent(Employee::getDepartment, Collectors.averagingInt(i -> i.getSalary())));
//		collect4.forEach((k, v) -> System.out.println(k.getName() + " = " + v));

		/*
		 * Map<Integer, List<Employee>> collect =
		 * employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
		 * collect.forEach((k,v) -> System.out.println(k +" = " +
		 * v.stream().map(Employee::getFirstName).collect(Collectors.joining(", "))));
		 */

//		System.out.println(employees.stream().allMatch(emp -> emp.getFirstName().length() > 3));

		/*
		 * employees.stream().sorted().dropWhile(emp ->
		 * emp.getFirstName().startsWith("A")).forEach(System.out::println);
		 * System.out.println(); employees.stream().sorted().takeWhile(emp ->
		 * emp.getFirstName().startsWith("A")).forEach(System.out::println);
		 */

//		employees.stream().map(Employee::getSalary).sorted().distinct()
//		.forEach(System.out::println);
//		
//		employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).distinct()
//				.forEach(System.out::println);

//		Employee employee12 = employees.stream().findAny().get();
//		System.out.println(employee12);
//		Employee employee12 = employees.stream().sorted(Comparator.reverseOrder()).findFirst().get();
//		System.out.println(employee12);
//		Iterator<Employee> iterator = employees.stream().sorted().iterator();
//		System.out.println(iterator.next());
		// employees.stream().limit(5).sorted().forEach(System.out::println);
		// System.out.println(employees.stream().sorted(Comparator.reverseOrder()).max((e1,e2)
		// -> e2.compareTo(e1)));;
		// employees.stream().peek(System.out::println).filter(e ->
		// e.getDepartment().getId()==501).forEach(System.out::println);
		// Employee reduce =
		// employees.stream().sorted(Comparator.reverseOrder()).reduce(employee, (e1,
		// e2) -> e1.getSalary() > 10 ? e1:e2);
		// System.out.println(reduce);

//		String name = "RajeshAnthari";
//		Map<Character, Long> collect = name.chars().mapToObj(i -> (char)i).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
//		collect.forEach((k,v) -> System.out.println( k + " --> " + v) );

		// employees.stream().skip(9).forEach(System.out::println);
//		ArrayList<Object> collect = employees.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//		collect.stream().forEachOrdered(System.out::println);
//		
		// Long collect2 = employees.stream().collect(Collectors.counting());
		// System.out.println(collect2);

//		Map<Department, List<Employee>> collect = employees.stream()
//				.collect(Collectors.groupingBy(emp -> emp.getDepartment()));
//		collect.forEach((k, v) -> System.out.println(
//				k.getName() + " --> " + v.stream().
//				map(Employee::getFirstName).collect(Collectors.joining(",")
//				)));
//		
//		Map<Department, Employee> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, 
//				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
//		collect.forEach((k,v) -> System.out.println(k.getName() + " --> " + v.getSalary()));

		// employees.stream().collect(Collectors.filtering(null, null));
//		List<Employee> collect = employees.stream().collect(Collectors.filtering(emp -> emp.getFirstName().startsWith("B"), Collectors.toList()));
//		collect.forEach(System.out::println);

//		Map<Department, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//		collect.forEach((k,v) -> System.out.println(k.getName() +" -> " + v.stream().collect(Collectors.mapping(Employee::getFirstName, Collectors.toCollection(ArrayList::new)))));
//		System.out.println();
//		Map<Department, IntSummaryStatistics> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingInt(Employee::getSalary)));
//		collect2.forEach((k,v) -> System.out.println(k.getName() + " --> " + v));
//		System.out.println();
//		Map<Department, IntSummaryStatistics> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.summarizingInt(Employee::getSalary)));
//		collect3.forEach((k,v) -> System.out.println(k.getName() + " --> " + v));
//		Map<Department, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//		collect.forEach((k,v) -> System.out.println(k.getName() +" -> " + v.stream().collect(Collectors.mapping(Employee::getFirstName, Collectors.joining(",","[","]")))));
//		
//		System.out.println(employees.stream().isParallel());
//		System.out.println(employees.stream().parallel().isParallel());
//		System.out.println(employees.stream().parallel().sequential().isParallel());

//		Optional<Employee> collect = employees.stream().collect(Collectors.maxBy((e1, e2) -> Integer.valueOf(e1.getSalary()).compareTo(Integer.valueOf(e2.getSalary()))));
//		System.out.println(collect.get());
//		Employee collect2 = employees.stream().collect(Collectors.collectingAndThen(Collectors.maxBy((e1, e2) -> Integer.valueOf(e1.getSalary()).compareTo(Integer.valueOf(e2.getSalary()))), Optional::get));
//		System.out.println(collect2);

//		Map<Department, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));
//		collect.forEach((k,v) -> System.out.println(k.getName() +" -> " + v.stream().collect(Collectors.mapping(Employee::getFirstName, Collectors.toCollection(ArrayList::new)))));

//		LinkedHashMap<Department, Employee> collect = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(), LinkedHashMap::new, Collectors.collectingAndThen(Collectors.maxBy((e1, e2) -> Integer.valueOf(e1.getSalary()).compareTo(Integer.valueOf(e2.getSalary()))), Optional::get)));
//		collect.forEach((k,v) -> System.out.println(k.getName() + " --> " + v.getSalary()+"--"+v.getFirstName() ));
		// Map<Boolean, Map<Department, String>> collect =
		// employees.stream().collect(Collectors.partitioningBy(emp ->
		// emp.getFirstName().startsWith("B"),
		// Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getFirstName,
		// Collectors.joining(",")))));
		// collect.forEach((k,v) -> System.out.println(k +" -> " + v.entrySet() ));

//		Map<Department, Object> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.teeing(
//				Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
//				Collectors.minBy(Comparator.comparingInt(Employee::getSalary)),
//				(e1,e2) -> {
//					return Map.of("MAX", e1, "MIN", e2);
//				})));
//		collect.forEach((k,v) -> System.out.println(k.getName() +" --> " + v));
//		

//		ConcurrentMap<String, Employee> collect = employees.stream().collect(Collectors.toConcurrentMap(Employee::getFirstName, Function.identity()));
//		collect.forEach((k,v) -> System.out.println(k +"==="+ v));

	}

}
