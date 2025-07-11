package com.tss.basics.arrays;

import java.util.Scanner;

public class MaxElementInArray {

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
		int maximum = array[0];

		for (int i = 0; i < size; i++) {

			if (array[i] > maximum) {
				maximum = array[i];
			}
		}
		
		System.out.println("Maximum Element in Array is : "+maximum);

	}

}
