package com.tss.creational.factory.model;

public class Maruti implements ICars {

	@Override
	public void start() {
		System.out.println("Maruti Car Started");
	}

	@Override
	public void stop() {
		System.out.println("Maruti Car Stopped");

	}

}
