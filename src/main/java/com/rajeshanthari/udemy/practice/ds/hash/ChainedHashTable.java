package com.rajeshanthari.udemy.practice.ds.hash;

import java.util.LinkedList;

import com.rajeshanthari.udemy.practice.ds.stack.Employee;

public class ChainedHashTable {

	LinkedList<StoredEmployee>[] table;

	public ChainedHashTable(int capacity) {
		table = new LinkedList[capacity];
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<StoredEmployee>();
		}
	}

	private int hashKey(String key) {
		return key.length() % table.length;
	}

}
