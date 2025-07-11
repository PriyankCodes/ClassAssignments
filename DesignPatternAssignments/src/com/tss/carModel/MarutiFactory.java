package com.tss.carModel;

public class MarutiFactory implements ICarFactory {

	@Override
	public ICars makeCars(CarType car) {
		return new Maruti();

	}

}
