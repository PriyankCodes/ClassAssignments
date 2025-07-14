package com.tss.liskovTest;

import com.tss.liskov.Bird;
import com.tss.liskov.Ostrich;
import com.tss.liskov.Pigeon;
import com.tss.liskov.Sparrow;

public class BirdTestViolate {

	public static void main(String[] args) {

		Bird sparrow = new Sparrow();
		Bird pigeon = new Pigeon();
		Bird ostrich = new Ostrich();

		sparrow.fly();
		pigeon.fly();
		ostrich.fly();
	}

}
