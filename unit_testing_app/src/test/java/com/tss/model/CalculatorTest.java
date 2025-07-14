package com.tss.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@AfterAll
	static void display() {
		System.out.println("Testing Done");
	}

	@Test
	void testAddition() {
		assertEquals(6, calculator.addition(1, 5));
		assertEquals(30, calculator.addition(20, 10));
		assertEquals(15, calculator.addition(10, 5));
		assertEquals(110, calculator.addition(100, 10));
	}

	@Test
	void testSubtraction() {
		assertEquals(-4, calculator.subtraction(1, 5));
		assertEquals(10, calculator.subtraction(20, 10));
		assertEquals(5, calculator.subtraction(10, 5));
		assertEquals(90, calculator.subtraction(100, 10));
	}

	@Test
	void testDivision() {

		assertThrows(ArithmeticException.class, () -> calculator.division(10, 0));
	}
}
