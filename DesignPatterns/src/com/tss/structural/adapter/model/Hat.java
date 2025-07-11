package com.tss.structural.adapter.model;

public class Hat {

	String shortName, longName;
	double price, discount;

	public Hat(String shortName, String longName, double price, double discount) {
		super();
		this.shortName = shortName;
		this.longName = longName;
		this.price = price;
		this.discount = discount;
	}

	public String getShortName() {
		return shortName;
	}

	public String getLongName() {
		return longName;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

}
