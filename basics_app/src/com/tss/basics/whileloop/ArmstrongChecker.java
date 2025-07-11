package com.tss.basics.whileloop;

import java.util.Scanner;

public class ArmstrongChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int number = scanner.nextInt();
		int temp = number;
		int sum = 0;
		int digit = 0;
		
		while(number > 0) {
			digit = number % 10;
	        sum += digit*digit*digit;
	        number = number / 10;
		}
		if(sum == temp) {
			System.out.println("Number is Armstrong");
		}
		else {
			System.out.println("Number is not Armstrong");
		}

	}

}
