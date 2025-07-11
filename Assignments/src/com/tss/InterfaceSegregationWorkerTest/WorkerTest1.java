package com.tss.InterfaceSegregationWorkerTest;

import com.tss.InterfaceSegregationWorker.IWorkable;
import com.tss.InterfaceSegregationWorker.IWorker1;
import com.tss.InterfaceSegregationWorker.Labour1;
import com.tss.InterfaceSegregationWorker.Robot1;

public class WorkerTest1 {
	public static void main(String[] args) {
		IWorker1 loader = new Labour1();
		loader.start();
		loader.stop();
		loader.eat();
		loader.rest();
		
		System.out.println();
		
		IWorkable robot = new Robot1();
		robot.start();
		robot.stop();

	}
}
