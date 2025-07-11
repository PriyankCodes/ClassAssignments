package com.tss.inheritance.model;

public interface DemoInterface {
	
	void method1();
	
	static void method2() {
		System.out.println("Inside Interface static Method2...");
	}
	
	default void method3() {
		System.out.println("Inside Interface default Method3...");
		method4();

	}
	
	private void method4() {
		System.out.println("Inside Interface private Method4...");

	}

}
