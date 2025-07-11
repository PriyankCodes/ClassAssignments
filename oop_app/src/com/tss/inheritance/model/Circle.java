package com.tss.inheritance.model;

public class Circle implements IShape {

	double PI = 3.14;
	double radius;

	@Override
	public void area() {
		System.out.println("Area of Circle is : " + (PI * radius * radius));
	}

	public Circle(double radius) {
		super();
		this.radius = radius;

	}

}
