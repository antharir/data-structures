package com.rajeshanthari.udemy.practice.ds.queue;

import com.rajeshanthari.udemy.practice.ds.stack.Employee;

public class QueueTest {
	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(5);
		aq.add(new Employee(101, "Rajesh", "Anthari"));
		aq.add(new Employee(102, "Ramana", "T"));
		aq.add(new Employee(103, "Satya", "V"));
		aq.add(new Employee(104, "Ajay", "P"));
		aq.printQueue();
		System.out.println(aq.remove());
		System.out.println(aq.remove());
		aq.add(new Employee(105, "Kishore", "N"));
		aq.add(new Employee(106, "Nishchal", "N"));
		//aq.add(new Employee(107, "Kaushik", "K"));
		//System.out.println(aq.remove());
		System.out.println(aq.peek());
		aq.printQueue();
	}
}
