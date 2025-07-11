package com.tss.test;

import java.util.function.BinaryOperator;

public class BinaryOperatorPOC {
	public static void main(String[] args) {

		BinaryOperator<Integer> sum = (a, b) -> a + b;

		BinaryOperator<String> concat = (a, b) -> a + " " + b;

		System.out.println("10 + 20 = " + sum.apply(10, 20));
		System.out.println("Concatenated : " + concat.apply("Good", "Morning"));
	}
}
