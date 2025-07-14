package com.tss.liskov;

public class OstrichLiskov implements INonFlyable {

	String color;
	public OstrichLiskov(String color) {
		super();
		this.color = color;
	}

	@Override
	public void getColor() {
		System.out.println("Color = " + color);
	}

	@Override
	public void Walk() {
		System.out.println("Ostrich Walks.");
	}

}
