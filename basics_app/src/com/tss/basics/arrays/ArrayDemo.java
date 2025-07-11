package com.tss.basics.arrays;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int numbers[] = new int[5];
		System.out.print("Enter 5 Numbers : ");
		for (int i = 0; i < 5; i++) {
			numbers[i] = scanner.nextInt();
		}

		for (int i = 0; i < 5; i++) {
			System.out.print("\t" + numbers[i]);
		}

	}

}
