package com.tss.basics.whileloop;

import java.util.Scanner;

public class PerfectNumberChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int number = scanner.nextInt();
		int i = 1;
		int sum = 0;

		while (i <= number / 2) {
			if (number % i == 0) {
				sum += i;
			}
			i++;
		}

		if (sum == number) {
			System.out.println(number + " is Perfect Number");
		} else {
			System.out.println(number + " is not Perfect Number");

		}
	}

}
