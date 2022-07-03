package com.rajeshanthari.udemy.practice.ds.proxy;

import java.lang.reflect.Proxy;

public class Runner {
	public static void main(String[] args) {
		PersonDao dao = (PersonDao) Proxy.newProxyInstance(PersonDao.class.getClassLoader(),
				PersonDaoImpl.class.getInterfaces(), new PersonDaoInvocationHandler(new PersonDaoImpl()));
		Person person = dao.findById(5);
		dao.save(person);
	}
}

class Person {

}

interface PersonDao {
	Person findById(int id);

	void save(Person person);

}

class PersonDaoImpl implements PersonDao {
	@Override
	public Person findById(int id) {
		System.out.println("findById");
		return new Person();
	}

	@Override
	public void save(Person person) {
		System.out.println("save");
	}

}
