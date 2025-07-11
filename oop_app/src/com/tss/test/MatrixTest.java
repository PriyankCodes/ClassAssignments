package com.tss.test;

import java.util.Scanner;

public class MatrixTest {

    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of Matrix: ");
        int size = scanner.nextInt();
        matrix = new int[size][size];

        readMatrix(size, scanner);
        printMatrix(size);
    }

    private static void readMatrix(int size, Scanner scanner) {
        System.out.println("Enter Matrix Elements:");
        for (int i = 0; i < size; i++) {
            readRows(i, size, scanner);
        }
    }

    private static void readRows(int i, int size, Scanner scanner) {
        for (int j = 0; j < size; j++) {
            matrix[i][j] = scanner.nextInt();
        }
    }

    private static void printMatrix(int size) {
        System.out.println("Matrix Elements:");
        for (int i = 0; i < size; i++) {
            printRows(i, size);
        }
    }

    private static void printRows(int i, int size) {
        for (int j = 0; j < size; j++) {
            System.out.print(matrix[i][j] + "\t");
        }
        System.out.println();
    }
}
