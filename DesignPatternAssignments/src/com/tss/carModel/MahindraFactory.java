package com.tss.carModel;

public class MahindraFactory implements ICarFactory {

	@Override
	public ICars makeCars(CarType car) {
		return new Mahindra();

	}

}
