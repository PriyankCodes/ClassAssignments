package com.tss.test;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number : ");
		int number = scanner.nextInt();

		if (number % 2 == 0) {
			System.out.println("Even Number");
			return;
		}
		System.out.println("Odd Number");

	}

}
