package com.rajeshanthari.udemy.practice.threads.part1;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		DataStore ds = new DataStore();
		new Thread(new Producer(ds)).start();
		new Thread(new Consumer(ds)).start();
	}
}

class Producer implements Runnable {
	private DataStore ds = null;

	public Producer(DataStore ds) {
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
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			counter++;
		}
	}
}

class Consumer implements Runnable {
	private DataStore ds = null;

	public Consumer(DataStore ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		System.out.println("In Consumer Run");
		try {
			for (String name = ds.get(); !name.equals("Pavindar"); name = ds.get()) {
				System.out.println("Consumer --> " + name);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

class DataStore {
	String name;
	boolean hasValue = false;

	public synchronized void put(String name) throws InterruptedException {
		while (hasValue) {
			wait();
		}
		this.name = name;
		hasValue = true;
		System.out.println("Added value -> " + name);
		notifyAll();
	}

	public synchronized String get() throws InterruptedException {
		if (!hasValue) {
			wait();
		}
		String name2 = this.name;
		hasValue = false;
		notifyAll();
		return name2;
	}

}
