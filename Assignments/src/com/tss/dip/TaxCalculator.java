package com.tss.dip;


public class TaxCalculator {
	private DBLogger dbLogger;

	public TaxCalculator() {

		this.dbLogger = new DBLogger();
	}
	

	public int calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println("Calculated Tax: " + tax);
		} catch (Exception e) {
			dbLogger.log("Error in tax calculation: Divide by zero or other issue. Details: " + e.getMessage());
			System.err.println("An error occurred during tax calculation. Check logs.");
		}
		return tax;
	}
}