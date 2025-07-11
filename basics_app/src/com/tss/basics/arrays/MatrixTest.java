package com.tss.basics.arrays;

import java.util.Scanner;

public class MatrixTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size of Matrix : ");
		int size = scanner.nextInt();
		int matrix[][] = new int[size][size];

		System.out.print("Enter Array Elements : ");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		System.out.println("Matrix Elements : ");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
