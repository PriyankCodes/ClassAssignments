package com.tss.dipTest;

import com.tss.dip.DBLogger1;
import com.tss.dip.FileLogger;
import com.tss.dip.ILogger;
import com.tss.dip.TaxCalculatorDIP;

public class DipNonViolationDemo {
	public static void main(String[] args) {
		System.out.println("--- Demonstrating DIP Non-Violation ---");

		System.out.println("\n--- Using DBLogger ---");
		ILogger dbLogger = new DBLogger1();
		TaxCalculatorDIP calculatorWithDBLogger = new TaxCalculatorDIP(dbLogger);
		calculatorWithDBLogger.calculateTax(100, 0);

		System.out.println("\n--- Using FileLogger ---");
		ILogger fileLogger = new FileLogger();
		TaxCalculatorDIP calculatorWithFileLogger = new TaxCalculatorDIP(fileLogger);
		calculatorWithFileLogger.calculateTax(50, 0);

		System.out.println("\n--- Changing Logger at Runtime ---");
		calculatorWithDBLogger.setLogger(fileLogger);
		calculatorWithDBLogger.calculateTax(200, 0);

		System.out.println("\n--- End of DIP Non-Violation Demo ---");
	}
}