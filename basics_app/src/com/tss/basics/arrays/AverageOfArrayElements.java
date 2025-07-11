package com.tss.basics.arrays;

import java.util.Scanner;

public class AverageOfArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size of Array : ");
		int size = scanner.nextInt();
		int array[] = new int[size];

		System.out.print("Enter Array Elements : ");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += array[i];
		}
		double average = sum / size;
		System.out.println("Sum of Array Element is : " + average);

	}

}
