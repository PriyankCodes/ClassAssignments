package com.tss.InterfaceSegregationWorker;

public class Robot implements IWorker {

	@Override
	public void startWork() {
		System.out.println("Robot starting work.");
	}

	@Override
	public void stopWork() {
		System.out.println("Robot stopping work.");
	}

	@Override
	public void eat() {
		System.out.println("Robot can not eat.");
	}

	@Override
	public void drink() {
		System.out.println("Robot can not drink.");
	}
}
