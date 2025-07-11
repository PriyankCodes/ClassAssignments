package com.tss.test;

import java.util.function.UnaryOperator;

public class UnaryOperatorPOC {
	public static void main(String[] args) {

		UnaryOperator<Integer> increment = x -> x + 1;

		UnaryOperator<String> toUpperCase = str -> str.toUpperCase();

		System.out.println("Increment 5 : " + increment.apply(5)); 
		System.out.println("Uppercase 'hello': " + toUpperCase.apply("hello")); 
	}
}
