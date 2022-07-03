package com.rajeshanthari.udemy.practice.ds.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDaoInvocationHandler implements InvocationHandler {

	private final PersonDao target;

	public PersonDaoInvocationHandler(PersonDao pDao) {
		this.target = pDao;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before " + method.getName());
		Object result = method.invoke(target, args);
		System.out.println("After " + method.getName());
		return result;
	}
}
