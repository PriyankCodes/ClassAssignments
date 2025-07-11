package com.tss.inheritance.test;

import com.tss.inheritance.model.BoxWeight;

public class BoxTest {

	public static void main(String[] args) {
		BoxWeight boxWeight = new BoxWeight();
		
		boxWeight.initialize(10, 20, 30);
		boxWeight.initializeBoxWeight(40);

		boxWeight.display();
		boxWeight.displayBox();
	}
}
