package com.tss.inheritance.test;

import com.tss.inheritance.model.Circle;
import com.tss.inheritance.model.Rectangle;

public class ShapeTest {

	public static void main(String[] args) {

		Circle circle = new Circle(50);
		
		circle.area();
		
		Rectangle rectangle = new Rectangle(10, 20);

		rectangle.area();
	}

}
