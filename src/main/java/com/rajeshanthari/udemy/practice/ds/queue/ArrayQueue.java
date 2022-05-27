package com.rajeshanthari.udemy.practice.ds.queue;

import java.util.NoSuchElementException;

import com.rajeshanthari.udemy.practice.ds.stack.Employee;

public class ArrayQueue {
	private Employee[] queue;
	private int front;
	private int back;

	public ArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}

	public void add(Employee emp) {
		if (back == queue.length) {
			Employee[] newArray = new Employee[2 * queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
			queue = newArray;
		}
		queue[back] = emp;
		back++;
	}

	public Employee remove() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		Employee emp = queue[front];
		queue[front] = null;
		front++;
		if (size() == 0) {
			front = 0;
			back = 0;
		}
		return emp;
	}

	public Employee peek() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		return queue[front];
	}

	public int size() {
		return back - front;
	}

	public void printQueue() {
		System.out.println("----------Start------------");
		for (int i = front; i < back; i++) {
			System.out.println(queue[i]);
		}
		System.out.println("----------End------------");
	}

}
