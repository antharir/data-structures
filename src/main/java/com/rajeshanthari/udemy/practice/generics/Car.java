package com.rajeshanthari.udemy.practice.generics;

import lombok.Data;

@Data
class Car {
	String brand;
	String carType = "Base Car";

	public void info() {
		System.out.println("Info: " + this.toString());
	}

	@Override
	public String toString() {
		return getBrand() + getCarType();
	}
}