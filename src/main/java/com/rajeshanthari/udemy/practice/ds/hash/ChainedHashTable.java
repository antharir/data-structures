package com.rajeshanthari.udemy.practice.ds.hash;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.LinkedList;

import com.rajeshanthari.udemy.practice.ds.hash.Animal.MyConsts;
import com.rajeshanthari.udemy.practice.ds.stack.Employee;

public class ChainedHashTable implements Serializable {
	
	public static final void main(String[] args) {
		
		System.out.println(Arrays.toString(NAMES.values()));
		System.out.println("Hello");
	}

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

class Animal {

	
	interface MyConsts {
		String name = "Hello";
	}
	
	public static void print(String name) {

	}
}

class Cat extends Animal {

	public static void print(String name) {
	}

}
enum NAMES {
	RAJESH,NISHCHAL
}