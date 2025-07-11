package com.tss.basics.arrays;

import java.util.Scanner;

public class ArrayBubbleSort {

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

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] > array[j]) {

					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Sorated Array :");
		for (int i = 0; i < size; i++) {
			System.out.print("\t" + array[i]);
		}

	}

}
