package com.tss.tasks;

public class MyTask2 extends Thread {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}