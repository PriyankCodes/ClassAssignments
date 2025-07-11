package com.tss.basics.whileloop;

import java.util.Scanner;

public class CalculateSumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a Number : ");
		int number = scanner.nextInt();
		int sum = 0;
		int digit = 0;
		
		while(number>0) {
			digit = number % 10;
	        sum += digit;
	        number = number / 10;
		}
		
		System.out.println("Sum of Digits of Number is "+sum);
	}

}
