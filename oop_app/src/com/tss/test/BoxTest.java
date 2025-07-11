package com.tss.test;
import com.tss.model.Box;

public class BoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box1 = new Box();

		box1.setHeight(10);
		System.out.println("Height of Box 1 : " + box1.getHeight());

		box1.display();
		System.out.println();

		Box box2 = new Box();

		box2.setWidth(50);
		System.out.println("Width of Box 1 : " + box2.getWidth());

		box2.display();

	}

}
