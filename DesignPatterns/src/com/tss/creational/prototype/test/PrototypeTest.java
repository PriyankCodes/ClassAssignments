package com.tss.creational.prototype.test;

import com.tss.creational.prototype.model.Circle;

public class PrototypeTest {
	public static void main(String[] args) {
		Circle original = new Circle(10);
		Circle copy = original.clone();

		original.draw();
		copy.draw();
		
		System.out.println(original.hashCode());
		System.out.println(copy.hashCode());

	}
}
