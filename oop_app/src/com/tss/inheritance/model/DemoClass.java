package com.tss.inheritance.model;

public class DemoClass implements DemoInterface {

	@Override
	public void method1() {
		System.out.println("Inside overridden class implemented Method1");

	}

	public void method2() {
		System.out.println("Inside Sataic class implemented Method2");
	}

	public void method4() {
		System.out.println("Inside private class implemented Method4");

	}

}
