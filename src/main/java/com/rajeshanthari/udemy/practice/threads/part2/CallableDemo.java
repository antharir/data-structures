package com.rajeshanthari.udemy.practice.threads.part2;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		FutureTask<String> futureTask = new FutureTask<>(new UserNameUtil(5, "Rajesh"));
		Thread th = new Thread(futureTask);
		th.start();
		System.out.println("Waiting for get");
		String string = futureTask.get(2, TimeUnit.SECONDS);
		System.out.println("Git String ->" + string);
	}
}

class UserNameUtil implements Callable<String> {

	private int noOfTime;
	private String name;

	public UserNameUtil(int noOfTime, String name) {
		this.noOfTime = noOfTime;
		this.name = name;
	}

	@Override
	public String call() throws InterruptedException {
		Thread.sleep(5000);
		return Collections.nCopies(noOfTime, name).stream().collect(Collectors.joining(","));
	}
}
