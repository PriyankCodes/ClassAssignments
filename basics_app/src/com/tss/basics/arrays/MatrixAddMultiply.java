package com.tss.basics.arrays;

import java.util.Scanner;

public class MatrixAddMultiply {

	static int i = 0;
	static int j = 0;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter size of First Matrix (m x n) : ");
		int m1 = scanner.nextInt();
		int n1 = scanner.nextInt();
		int matrix1[][] = new int[m1][n1];
		System.out.print("Enter First Matrix Elements : ");
		matrix1 = readMatrix(m1, n1);

		System.out.print("\nEnter size of Second Matrix (m x n) : ");
		int m2 = scanner.nextInt();
		int n2 = scanner.nextInt();
		int matrix2[][] = new int[m2][n2];
		System.out.print("Enter Second Matrix Elements : ");
		matrix2 = readMatrix(m2, n2);

		int sum[][] = matrixAddition(matrix1, matrix2, m1, n1, m2, n2);
		printMatrix(m1, n1, sum);

		int multiply[][] = matrixMultiplication(matrix1, matrix2, m1, n1, m2, n2);
		printMatrix(m1, n1, multiply);

	}

	private static void printMatrix(int m, int n, int[][] result) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static int[][] readMatrix(int m, int n) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[m][n];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		return matrix;
	}

	private static int[][] matrixAddition(int[][] matrix1, int[][] matrix2, int m1, int n1, int m2, int n2) {

		int[][] result = new int[m1][n1];
		if ((m1 == m2) && (n1 == n2)) {
			for (i = 0; i < m1; i++) {
				for (j = 0; j < n1; j++) {
					result[i][j] = matrix1[i][j] + matrix2[i][j];
				}
			}
			System.out.println("\nAddition of Matrices : ");

		} else {
			System.out.println("Addition can not be Done");
			return null;
		}
		return result;
	}

	private static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2, int m1, int n1, int m2, int n2) {
		int[][] result = new int[m1][n1];
		if ((m1 == m2) && (n1 == n2)) {
			for (i = 0; i < m1; i++) {
				for (j = 0; j < n1; j++) {
					for (int k = 0; k < m1; k++) {
						result[i][j] += matrix1[i][k] * matrix2[k][j];
					}
				}
			}

			System.out.println("\nMultiplication of Matrices : ");
			return result;
		} else {
			System.out.println("Multiplication can not be Done");
			return null;
		}
	}

}
