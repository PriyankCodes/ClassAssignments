package com.tss.structural.composite.model;

public class FileLeaf implements IFileComponent {
	private String name;

	public FileLeaf(String name) {
		this.name = name;
	}

	@Override
	public void showDetails() {
		System.out.println("File: " + name);
	}
}
