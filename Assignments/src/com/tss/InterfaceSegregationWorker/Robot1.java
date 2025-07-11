package com.tss.InterfaceSegregationWorker;

public class Robot1 implements IWorkable {

	@Override
	public void start() {
		System.out.println("Robot starting work.");
	}

	@Override
	public void stop() {
		System.out.println("Robot stopping work.");
	}
}
