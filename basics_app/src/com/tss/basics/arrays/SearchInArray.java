package com.tss.basics.arrays;

import java.util.Scanner;

public class SearchInArray {

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

		System.out.print("Enter Element For Search in Array : ");
		int element = scanner.nextInt();

		boolean found = false;
		int index=0;

		for (int i = 0; i < size; i++) {
			if (array[i] == element) {
				found = true;
				index = i;
			}
		}
		
		if(found) {
			System.out.println("Element found in Array at index : "+index);
		}else {
			System.out.println("Element Not Found in Array");
		}

	}

}
