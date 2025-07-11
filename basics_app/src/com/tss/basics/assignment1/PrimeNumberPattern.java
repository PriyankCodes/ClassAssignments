package com.tss.basics.assignment1;

import java.util.Scanner;

public class PrimeNumberPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		int rows;
		System.out.print("Enter Rows to Print : ");
		rows = scanner.nextInt();
		int primeNumber = 2;

		int i = 1;
		while (i <= rows) {
			int j = 1;
			while (j <= i) {
				while (!isPrimeNumber(primeNumber)) {
					primeNumber++;
				}
				System.out.print(primeNumber + " ");
				primeNumber++;
				j++;
			}
			System.out.println();
			i++;
		}

	}

	private static boolean isPrimeNumber(int number) {
		int i = 2;
		int count = 0;

		while (i < (number/2)) {
			if (number % i == 0) {
				count += 1;
			}
			i++;
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

}
