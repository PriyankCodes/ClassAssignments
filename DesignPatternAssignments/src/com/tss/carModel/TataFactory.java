package com.tss.carModel;

public class TataFactory implements ICarFactory {

	@Override
	public ICars makeCars(CarType car) {
		return new Tata();

	}

}
