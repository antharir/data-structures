package com.rajeshanthari.udemy.practice.generics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ClassFactory {
	public static <T extends Car> T printInfo(T car) {
		car.info();
		return car;
	}

	public static <T extends Car> void printCarsInfo(List<T> car) {
		System.out.println("Simple loop");
		car.stream().filter(isNull).forEach(i -> i.info());
	}

	@SafeVarargs
	public static <T extends Car> void printCarsInfo(List<? extends Car>... cars) {
		System.out.println("Var args");
		Arrays.asList(cars).stream().flatMap(x -> x.stream()).filter(isNull).forEach(Car::info);
	}

	static Predicate<Car> isNull = car -> !Objects.isNull(car);

	public static void printTiagoCarsInfo(List<? super Tiago> car) {
		System.out.println("Simple Tiago loop");
		car.stream().forEach(System.out::println);
	}

}
