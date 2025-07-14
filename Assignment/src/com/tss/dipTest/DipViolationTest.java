package com.tss.dipTest;

import com.tss.dip.TaxCalculator;

public class DipViolationTest {
	public static void main(String[] args) {

		TaxCalculator calculator = new TaxCalculator();

		System.out.println("\nCalculating tax for (100, 10):");
		calculator.calculateTax(100, 10);

		System.out.println("\nCalculating tax for (100, 0):");
		calculator.calculateTax(100, 0);
	}
}