package com.tss.liskov;

public class SparrowLiskov implements IFlyable {

	String color;
	public SparrowLiskov(String color) {
		super();
		this.color = color;
	}

	@Override
	public void getColor() {
		System.out.println("Color = " + color);
	}

	@Override
	public void Fly() {
		System.out.println("Sparrow Fly.");
	}

}
