package com.tss.solid;

public class Invoice {
	private int id;
	private String description;
	private double cost;
	private double discountPercent;
	public static final double TAX_PERCENT = 10.0;

	public Invoice() {
	}

	public Invoice(int id, String description, double cost, double discountPercent) {
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.discountPercent = discountPercent;
	}

	public double calculateTax() {
		return cost * TAX_PERCENT / 100;
	}

	public double calculateDiscount() {
		return cost * discountPercent / 100;
	}

	public double calculateFinalCost() {
		return cost + calculateTax() - calculateDiscount();
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public void print() {
		System.out.printf("%-5s %-20s %-10s %-10s %-20s %-15s%n", "ID", "Description", "Amount", "Tax(%)",
				"Discount Percentage", "Final Amount");
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("%-5d %-20s %-10.2f %-10.2f %-20.2f %-15.2f%n", id, description, cost, TAX_PERCENT,
				discountPercent, calculateFinalCost());
	}
}
