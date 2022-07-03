package com.rajeshanthari.udemy.practice.threads.part2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo2 {

	public static void main(String[] args) {
		BlockingQueue<String> ds = new ArrayBlockingQueue<>(1);
		new Thread(new Producer(ds)).start();
		new Thread(new Consumer(ds)).start();
	}
}

class Producer implements Runnable {
	private BlockingQueue<String> ds = null;

	public Producer(BlockingQueue<String> ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		System.out.println("In Producer Run");
		String[] names = { "Rajesh", "Usha", "Shiva", "Pavindar" };
		int counter = 0;
		while (counter < names.length) {
			try {
				ds.put(names[counter]);
				System.out.println("Producer --> " + names[counter]);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			counter++;
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<String> ds = null;

	public Consumer(BlockingQueue<String> ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		System.out.println("In Consumer Run");
		for (String name = ds.poll(); !name.equals("Pavindar"); name = ds.poll()) {
			System.out.println("Consumer --> " + name);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
