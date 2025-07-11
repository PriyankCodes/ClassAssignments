package com.tss.test;

import java.util.Scanner;
import java.util.function.BiFunction;

public class AdditionTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		BiFunction<Integer, Integer, Integer> add = (number1, number2) -> {
			return (number1 + number2);
		};

		System.out.print("Enter number1 : ");
		int number1 = scanner.nextInt();

		System.out.print("Enter number2 : ");
		int number2 = scanner.nextInt();

		System.out.println("Addition is : " + add.apply(number1, number2));

	}

}
