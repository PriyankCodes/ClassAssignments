package com.tss.model;

public class TwoWheel implements IVehicle {

	@Override
	public String generateLicencePlate() {

		int number = (int) (Math.random() * (9999 - 1000) + 1000);
		return "TW" + number;
	}

}
