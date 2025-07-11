package com.tss.creational.builder.model;

public class Computer {
	private String CPU;
	private String RAM;
	private String storage;
	private boolean graphicsEnabled;

	public Computer(String CPU, String RAM, String storage, boolean graphicsEnabled) {
		this.CPU = CPU;
		this.RAM = RAM;
		this.storage = storage;
		this.graphicsEnabled = graphicsEnabled;
	}

	@Override
	public String toString() {
		return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", graphicsEnabled=" + graphicsEnabled
				+ "]";
	}
}
