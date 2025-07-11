package com.tss.inheritance.model;

public class Rectangle implements IShape {

	double length;
	double width;

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public void area() {
		System.out.println("Area of Rectangle is : " + (length * width));

	}

}
