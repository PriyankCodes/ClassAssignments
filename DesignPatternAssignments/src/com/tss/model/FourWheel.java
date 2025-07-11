package com.tss.model;

public class FourWheel implements IVehicle {

	@Override
	public String generateLicencePlate() {
		
		int number = (int) (Math.random() * (9999 - 1000) + 1000);
		return "FW" + number;

	}

}
