package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class FindMaximunInThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter First Number : ");
		int number1 = scanner.nextInt();
		
		System.out.print("Enter Second Number : ");
		int number2 = scanner.nextInt();
		
		System.out.print("Enter Third Number : ");
		int number3 = scanner.nextInt();
		
		findMaximum(number1, number2, number3);
		
		
	}
	
	private static void findMaximum(int number1 , int number2, int number3) {
		if(number1 > number2 && number1 > number3) {
			System.out.println(number1+" is Maximum Number");
		}
		else if(number2 > number3) {
			System.out.println(number2+" is Maximum Number");
		}
		else {
			System.out.println(number3+" is Maximum Number");
		}
	}

}
