package com.rajeshanthari.udemy.practice.ds.stack;

import java.util.EmptyStackException;

class ArrayStack {
	private Employee[] stack;
	private int top;

	public ArrayStack(int capacity) {
		stack = new Employee[capacity];
	}

	public void push(Employee value) {
		if (isFull()) {
			Employee[] newStack = new Employee[2 * stack.length];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			this.stack = newStack;
		}
		stack[top++] = value;
	}

	public Employee pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Employee employee = stack[--top];
		stack[top] = null;
		return employee;
	}

	public Employee peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack[top - 1];
	}

	private boolean isFull() {
		return top == stack.length;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public void printStack() {
		System.out.println("---------Start---------------");
		for (int i = top - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
		System.out.println("---------End---------------");
	}

}