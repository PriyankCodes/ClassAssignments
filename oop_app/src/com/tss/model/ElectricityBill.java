package com.tss.model;

public class ElectricityBill {

	private int apartmentNumber;
	private double unitsConsumed;
	private static double costPerUnit = 5;
	private double billAmount;

	public ElectricityBill() {
		apartmentNumber = 0;
		unitsConsumed = 0;
		billAmount = 0;

	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public static double getCostPerUnit() {
		return costPerUnit;
	}

	public static void setCostPerUnit(double costPerUnit) {
		ElectricityBill.costPerUnit = costPerUnit;
	}

	public void calculateBill() {
		billAmount = unitsConsumed * costPerUnit;
		System.out.println("Total Bill = " + billAmount);
	}

	public static void changeCostPerUnit(double newCost) {
		costPerUnit = newCost;
	}

	public static void displayCurrentRate() {
		System.out.println("Current rate = " + costPerUnit);
	}

	@Override
	public String toString() {
		return "[apartmentNumber=" + apartmentNumber + ", unitsConsumed=" + unitsConsumed + ", billAmount=" + billAmount
				+ "]";
	}

}
