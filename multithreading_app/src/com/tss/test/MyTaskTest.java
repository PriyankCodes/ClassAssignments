package com.tss.test;

import com.tss.tasks.MyTask;
import com.tss.tasks.MyTask2;

public class MyTaskTest {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new MyTask(), "Thread1");
		thread1.start();

		Thread thread2 = new Thread(new MyTask2(), "Thread2");
		thread2.start();

		Thread thread3 = new Thread(new MyTask2(), "Thread3");
		thread3.start();

		Thread thread4 = new Thread(new MyTask(), "Thread4");
		thread4.start();
	}

}