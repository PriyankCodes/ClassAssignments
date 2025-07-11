package com.tss.creational.factory.test;

import com.tss.creational.factory.model.CarFactory;
import com.tss.creational.factory.model.CarType;
import com.tss.creational.factory.model.ICars;

public class CarTest {

	public static void main(String[] args) {

		CarFactory carFactory = new CarFactory();

		ICars maruti = carFactory.makeCars(CarType.Maruti);
		maruti.start();
		maruti.stop();
		System.out.println();

		ICars tata = carFactory.makeCars(CarType.Tata);
		tata.start();
		tata.stop();
		System.out.println();

		ICars mahindra = carFactory.makeCars(CarType.Mahindra);
		mahindra.start();
		mahindra.stop();

	}

}
