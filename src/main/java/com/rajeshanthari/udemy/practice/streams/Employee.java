package com.rajeshanthari.udemy.practice.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Comparable<Employee> {
	private int id;
	private String firstName;
	private String lastName;
	private Department department;
	private int salary;
	
	@Override
	public int compareTo(Employee o) {
		return this.getFirstName().compareTo(o.getFirstName());
	}
}