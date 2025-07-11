package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class TotalWaterBillChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Units Consumed : ");
        double units = scanner.nextDouble();

        findWaterBill(units);
    }

    private static void findWaterBill(double units) {

        double left_units = 0;
        double meter_charge = 75.0;
        double charge = 0;
        double water_bill = 0;

        if (units > 250) 
        {
            left_units = units - 250;
            charge += left_units * 20;
            units -= left_units;
        }
        if (units > 100) {
            left_units = units - 100;
            charge += left_units * 10;
            units -= left_units;
        }
        if (units > 0) {
            charge += units * 5;
        }

        water_bill = charge + meter_charge;

        System.out.println("Your Total Water Bill is : " + water_bill);
    }
}
