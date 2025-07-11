package com.tss.basics.assignment1;

import java.util.Scanner;

public class ArrayAveragePair {

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
		double average = (double) sum / size;

		System.out.println("Average is : " + average);

		arraySort(array, 0, size - 1); 
		pairFinder(array, size, average);

	}

	private static void pairFinder(int arraySorted[], int size, double average) {
		boolean pair = false;
		int i = 0;
		int j = size - 1;
		int pair1 = 0;
		int pair2 = 0;

		while (i < j) {

			int currentSum = arraySorted[i] + arraySorted[j];
			if (currentSum == average) {
				pair = true;
				pair1 = arraySorted[i];
				pair2 = arraySorted[j];
				break;
			} else if (currentSum < average) {
				i++;
			} else {
				j--;
			}

		}
		if (pair) {
			System.out.println("Pair Found : " + pair1 + " + " + pair2);
		} else {
			System.out.println("Pair Not Found");
		}
	}

	private static void arraySort(int[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			arraySort(array, low, pi - 1);
			arraySort(array, pi + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}

}
