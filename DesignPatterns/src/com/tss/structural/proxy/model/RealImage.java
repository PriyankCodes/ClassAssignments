package com.tss.structural.proxy.model;

public 	class RealImage implements IImage {
	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadImageFromDisk();
	}

	private void loadImageFromDisk() {
		System.out.println("Loading image: " + filename);
	}

	public void display() {
		System.out.println("Displaying image: " + filename);
	}
}