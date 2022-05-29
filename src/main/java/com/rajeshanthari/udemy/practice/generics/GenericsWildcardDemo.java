package com.rajeshanthari.udemy.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcardDemo {

	public static void main(String[] args) {
		{
			// Upper bounded wild cards
			List<Tata> tataCars = new ArrayList<>();
			tataCars.add(new Tata());
			tataCars.add(new Tiago());
			tataCars.add(new Altroz());
			tataCars.add(null);
			List<Hyundai> hyundaiCars = new ArrayList<>();
			hyundaiCars.add(new Grandi10());
			hyundaiCars.add(new Santro());
			// ClassFactory.printCarsInfo(tataCars);
			// ClassFactory.printCarsInfo(hyundaiCars);
			// ClassFactory.printCarsInfo(hyundaiCars, tataCars);

		}
		// Lower ounded wild cards
		List<Tata> tiagoCars = new ArrayList<>();
		tiagoCars.add(new Tiago());
		tiagoCars.add(new Tiago());
		tiagoCars.add(new Tiago());
		ClassFactory.printTiagoCarsInfo(tiagoCars);

	}
}
