package com.tss.structural.adapter.model;

public class Biscuit implements IItems {

	String name;
	double price;

	@Override
	public String getItemName() {
		return name;
	}

	@Override
	public double getItemPrice() {
		return price;
	}

	public Biscuit(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
