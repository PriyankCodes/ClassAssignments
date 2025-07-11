package com.tss.structural.facade.test;

import java.util.Scanner;

import com.tss.structural.facade.model.HotelReception;

public class HotelTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("1. Indian Menu \n2. Italian Menu => ");
		int menu = scanner.nextInt();
		System.out.println();

		HotelReception hotelReception = new HotelReception();

		if (menu == 1) {
			hotelReception.getIndianMenu();
		}
		if (menu == 2) {
			hotelReception.getItalianMenu();
		}
		if (menu != 1 && menu != 2) {
			System.out.println("Invalid Menu Option.");
		}
	}

}
