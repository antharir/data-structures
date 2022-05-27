package com.rajeshanthari.udemy.practice.ds.stack;

import java.util.LinkedList;
import java.util.ListIterator;

public class StackTest {
	public static void main(String[] args) {
//		ArrayStack as = new ArrayStack(2);
//		as.push(new Employee(1, "Rajesh", "Anthari"));
//		as.push(new Employee(2, "Pavindar", "B"));
//		as.push(new Employee(3, "Shiva", "B"));
//		as.printStack();
//		System.out.println(as.peek());
//		as.printStack();
//		System.out.println(as.pop());
//		as.printStack();

		LinkedStack ap = new LinkedStack();
		ap.push(new Employee(1, "Rajesh", "Anthari"));
		ap.push(new Employee(2, "Pavindar", "B"));
		ap.push(new Employee(3, "Shiva", "B"));
		ap.printStack();
		System.out.println(ap.peek());
		ap.printStack();
		System.out.println(ap.pop());
		ap.printStack();

	}
}

class LinkedStack {
	private LinkedList<Employee> stack;

	public LinkedStack() {
		stack = new LinkedList<>();
	}

	public void push(Employee e) {
		stack.push(e);
	}

	public Employee pop() {
		return stack.pop();
	}

	public Employee peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public void printStack() {
		ListIterator<Employee> empList = stack.listIterator();
		System.out.println("-----Start----------");
		while (empList.hasNext()) {
			System.out.println(empList.next());
		}
		System.out.println("-----End----------");
	}

}
