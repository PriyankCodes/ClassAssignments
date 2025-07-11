package com.tss.model;

public class Box {

	private int height;
	private int width;
	private int depth;

	public void initialize() {
		height = 0;
		width = 0;
		depth = 0;
	}

	// setters
	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	// getters
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	public void display() {
		System.out.println("Height = " + height);
		System.out.println("Width = " + width);
		System.out.println("Depth = " + depth);

	}

}
