package com.tss.test;

import com.tss.tasks.MyThread;

public class MainThread {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread());

		Thread.currentThread().setName("MaIN");

		System.out.println(Thread.currentThread());

		Thread.currentThread().setPriority(9);
		System.out.println(Thread.currentThread());

		MyThread thread1 = new MyThread("thread1"); // born
		thread1.start(); // runnable
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

		MyThread thread2 = new MyThread("thread2"); // born
		thread2.start(); // runnable

		MyThread thread3 = new MyThread("thread3"); // born
		thread3.start(); // runnable

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Exiting");
	}

}
