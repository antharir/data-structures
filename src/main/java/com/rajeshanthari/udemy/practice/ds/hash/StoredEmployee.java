package com.rajeshanthari.udemy.practice.ds.hash;

import com.rajeshanthari.udemy.practice.ds.stack.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoredEmployee {
	private String key;
	private Employee employee;
}
