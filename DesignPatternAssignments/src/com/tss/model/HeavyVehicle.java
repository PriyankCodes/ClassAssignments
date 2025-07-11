package com.tss.model;

public class HeavyVehicle implements IVehicle {

	@Override
	public String generateLicencePlate() {

		int number = (int) (Math.random() * (999999 - 100000) + 100000);
		return "HW" + number;
	}

}
