package com.tss.model;

public class Customer {
	private String itemName;
	private double price, tax, shippingCharge;
	private double amount;

	public Customer(String itemName, double price, double tax) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.tax = tax;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "=====Total Bill===== \n itemName = " + itemName + "\n price = " + price + "\n tax = " + tax + "\n shippingCharge = "
				+ shippingCharge + "\n amount = " + amount;
	}

}
