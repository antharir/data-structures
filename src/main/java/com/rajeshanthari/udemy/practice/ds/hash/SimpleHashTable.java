package com.rajeshanthari.udemy.practice.ds.hash;

import com.rajeshanthari.udemy.practice.ds.stack.Employee;

public class SimpleHashTable {
	private StoredEmployee[] table;

	public SimpleHashTable(int capacity) {
		table = new StoredEmployee[capacity];
	}

	private int hashKey(String key) {
		return key.length() % table.length;
	}

	private boolean occupied(int index) {
		return table[index] != null;
	}

	public void put(String key, Employee emp) {
		int hashedKey = hashKey(key);
		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == table.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}
			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % table.length;
			}
		}
		if (occupied(hashedKey)) {
			System.out.println("Employee already exists in position. :" + key);
		} else {
			table[hashedKey] = new StoredEmployee(key, emp);
		}
	}

	public Employee get(String key) {
		int hashedkey = findKey(key);

		if (hashedkey != -1) {
			return table[hashedkey].getEmployee();
		} else {
			return null;
		}

	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);
		if (table[hashedKey] != null && table[hashedKey].getKey().equals(key)) {
			return hashedKey;
		}
		int stopIndex = hashedKey;
		if (hashedKey == table.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}
		while (hashedKey != stopIndex && table[hashedKey] != null && !table[hashedKey].getKey().equals(key)) {
			hashedKey = (hashedKey + 1) % table.length;
		}

		if (table[hashedKey] != null && table[hashedKey].getKey().equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
	}

	public Employee remove(String key) {
		int hashedKey = findKey(key);
		Employee emp = null;
		if (hashedKey != -1 && table[hashedKey] != null) {
			emp = table[hashedKey].getEmployee();
			table[hashedKey] = null;
		}
		return emp;
	}

	public void printTable() {
		System.out.println("--------Start---------");
		for (int i = 0; i < table.length; i++) {
			System.out.println(table[i]);
		}
		System.out.println("--------End---------");
	}

}
