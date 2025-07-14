package com.tss.liskovTest;

import java.util.Scanner;

import com.tss.liskov.OstrichLiskov;
import com.tss.liskov.SparrowLiskov;

public class BirdLiskovTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		SparrowLiskov sparrow = new SparrowLiskov("brown");
		OstrichLiskov ostrich = new OstrichLiskov("Brown");

		sparrow.Fly();
		sparrow.getColor();

		System.out.println();

		ostrich.Walk();
		ostrich.getColor();
		scanner.close();

	}

}
