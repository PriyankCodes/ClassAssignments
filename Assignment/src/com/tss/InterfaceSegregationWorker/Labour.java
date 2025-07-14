package com.tss.InterfaceSegregationWorker;

public class Labour implements IWorker {

	@Override
	public void startWork() {
		System.out.println("Labour starting work.");
	}

	@Override
	public void stopWork() {
		System.out.println("Labour stopping work.");
	}

	@Override
	public void eat() {
		System.out.println("Labour eating lunch.");
	}

	@Override
	public void drink() {
		System.out.println("Labour drinking water.");
	}
}
