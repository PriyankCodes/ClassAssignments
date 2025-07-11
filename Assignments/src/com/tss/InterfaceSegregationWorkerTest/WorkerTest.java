package com.tss.InterfaceSegregationWorkerTest;

import com.tss.InterfaceSegregationWorker.IWorker;
import com.tss.InterfaceSegregationWorker.Labour;
import com.tss.InterfaceSegregationWorker.Robot;

public class WorkerTest {
	public static void main(String[] args) {
		IWorker labour = new Labour();
		labour.startWork();
		labour.eat();
		labour.drink();
		labour.stopWork();

		System.out.println();
		
		IWorker robot = new Robot();
		robot.startWork();
		robot.eat(); 
		robot.drink();
		robot.stopWork();
	}
}
