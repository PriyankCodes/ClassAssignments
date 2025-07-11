package com.tss.basics;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter First Number : ");
		int number1 = sc.nextInt();
		
		System.out.print("Enter Second Number : ");
		int number2 = sc.nextInt();
		
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
