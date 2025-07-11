package com.tss.model;

public class Demo {
	int a;
	int b;
	static int c;

	public void display() {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}

	public void increment() {
		a++;
		b++;
		c++;
	}
	
	{
		System.out.println("Inside Demo");
	}
	
	static {
		System.out.println("Inside Demo static");
	}
}
