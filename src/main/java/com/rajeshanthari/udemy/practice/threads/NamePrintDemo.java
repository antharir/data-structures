package com.rajeshanthari.udemy.practice.threads;

import java.util.ArrayList;
import java.util.List;

public class NamePrintDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread th = new Thread(new NamePrintThread());
		th.start();
		Thread.sleep(100);
		th.interrupt();
		th.join();
		System.out.println("End");
	}
}

class NamePrintThread implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10000; i++) {
				if (Thread.interrupted()) {
					//throw new InterruptedException("Rajesh custom interruption = " + i);
				}
				List<String> strs = new ArrayList<>(1500);
				for (int j = 0; j < 15000; j++) {
					strs.add("Temp"+j);
				}
				System.out.println("Rajesh -> " + Math.random());
			}
		} catch (Exception e) {
			System.out.println("Error -> "+e.getMessage());
		}

	}
}