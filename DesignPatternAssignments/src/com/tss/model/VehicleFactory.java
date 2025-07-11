package com.tss.model;

public class VehicleFactory {

	public static IVehicle getVehicle(vehicleType vehicle) {

		if (vehicle.equals(vehicleType.TwoWheel)) {
			return new TwoWheel();
		}

		if (vehicle.equals(vehicleType.FourWheel)) {
			return new FourWheel();
		}

		if (vehicle.equals(vehicleType.HeavyVehicle)) {
			return new HeavyVehicle();
		}

		return null;

	}
}
