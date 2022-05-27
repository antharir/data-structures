package com.rajeshanthari.udemy.practice.ds.hash;

import com.rajeshanthari.udemy.practice.ds.stack.Employee;

public class HashTableTest {

	public static void main(String[] args) {
		SimpleHashTable sm = new SimpleHashTable(10);
		Employee rajeshEmp = new Employee(101, "Rajesh", "Anthari");
		Employee ramanEmp = new Employee(102, "Ramana", "T");
		Employee satyaEmp = new Employee(103, "Satya", "V");
		Employee ajayEmp = new Employee(104, "Ajay", "P");
		Employee kishoreEmp = new Employee(105, "Kishore", "N");
		Employee nishchalEmp = new Employee(106, "Nishchal", "N");
		sm.put("rajesh", rajeshEmp);
		sm.put("ramana", ramanEmp);
		sm.put("satya", satyaEmp);
		sm.put("ajay", ajayEmp);
		sm.put("kishore", kishoreEmp);
		sm.put("ni", nishchalEmp);
		sm.printTable();
		System.out.println(sm.get("ni"));
		System.out.println(sm.remove("ramana"));
		sm.printTable();
	}
}
