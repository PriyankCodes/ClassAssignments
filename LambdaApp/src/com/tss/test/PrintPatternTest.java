package com.tss.test;

import java.util.Scanner;
import java.util.function.Consumer;

public class PrintPatternTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter rows : ");
		int rows = scanner.nextInt();

		Consumer<Integer> printPattern = (row) -> {
			int num = 1;
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(num++ + " ");
				}
				System.out.println();
			}
		};

		printPattern.accept(rows);
	}

}
