package com.tss.basics.whileloop;

import java.util.Scanner;

public class PrimeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int number = scanner.nextInt();
		int i = 2;
		int count = 0;

		while (i < number) {
			if (number % i == 0) {
				count += 1;
			}
			i++;
		}
		if (count > 0) {
			System.out.println(number + " is not Prime NUmber");
		} else {
			System.out.println(number + " is Prime NUmber");
		}
	}

}
