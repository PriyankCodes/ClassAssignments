package com.tss.inheritance.model;

public class BoxWeight extends Box {

	private int weight;
	private int height;
	private int depth;

	public void initializeBoxWeight(int weight) {

		this.weight = weight;
	}

	public void displayBox() {
		System.out.println("Weight = " + weight);

	}

	public void display() {
		System.out.println("Weight = " + weight);
		System.out.println("Height = " + height);
		System.out.println("Depth = " + depth);

	}

	public void initialize(int height, int weight, int depth) {
		this.weight = 10;
		this.height = 20;
		this.depth = 30;

	}
}
