package com.tss.carTest;

import java.util.Scanner;

import com.tss.carModel.CarType;
import com.tss.carModel.ICarFactory;
import com.tss.carModel.ICars;
import com.tss.carModel.MahindraFactory;
import com.tss.carModel.MarutiFactory;
import com.tss.carModel.TataFactory;

public class CarTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Car Type : ");
		System.out.print("1. MarutiCar \n2. TataCar \n3. MahindraCar => ");

		int car = scanner.nextInt();

		if (car == 1) {
			ICarFactory marutiFactory = new MarutiFactory();
			ICars maruti = marutiFactory.makeCars(CarType.Maruti);
			maruti.start();
			maruti.stop();
			System.out.println();
		}

		if (car == 2) {
			ICarFactory tataFactory = new TataFactory();
			ICars tata = tataFactory.makeCars(CarType.Tata);
			tata.start();
			tata.stop();
			System.out.println();
		}

		if (car == 3) {
			ICarFactory mahindraFactory = new MahindraFactory();
			ICars mahindra = mahindraFactory.makeCars(CarType.Mahindra);
			mahindra.start();
			mahindra.stop();
		}

		if (car != 1 && car != 2 && car != 3) {
			System.out.println("Enter valid car");
		}

	}

}
