package com.tss.basics.assignment1;

import java.util.Scanner;

public class SquaredSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size of Array : ");
		int size = scanner.nextInt();
		int array[] = new int[size];

		System.out.print("Enter Array Elements in Sorted Manner : ");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}

		int[] arraySquare = squaredArray(size, array);

		System.out.println("Sorted Squared Array: ");
		for (int i = 0; i < size; i++) {
			System.out.print("\t" + arraySquare[i]);
		}

	}

	private static int[] squaredArray(int size, int array[]) {
		int left = 0;
		int right = size - 1;
		int pos = size - 1;
		int[] arraySquare = new int[size];

		while (left <= right) {
			int leftSquare = array[left] * array[left];
			int rightSquare = array[right] * array[right];
			if (leftSquare > rightSquare) {
				arraySquare[pos] = leftSquare;
				pos--;
				left++;
			} else {
				arraySquare[pos] = rightSquare;
				pos--;
				right--;
			}
		}
		return arraySquare;

	}
}
