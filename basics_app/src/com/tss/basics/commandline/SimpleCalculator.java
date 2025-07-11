package com.tss.basics.commandline;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		
		
		int number1 = Integer.parseInt(args[0]);
		
		int number2 = Integer.parseInt(args[1]);
		
		addition(number1, number2);
		subtraction(number1, number2);
		multiplication(number1, number2);
		division(number1, number2);
		
	}
	
	private static void addition(int number1, int number2) {
		int sum = number1 + number2;
		System.out.println("Sum = "+sum);
	}
	
	private static void subtraction(int number1, int number2) {
		int difference = number1 - number2;
		System.out.println("Difference = "+difference);
	}
	
	private static void multiplication(int number1, int number2) {
		int multiplication = number1 * number2;
		System.out.println("Multiplication = "+multiplication);
	}
	
	private static void division(int number1, int number2) {
		int division = number1 / number2;
		System.out.println("Division = "+division);
	}

}
