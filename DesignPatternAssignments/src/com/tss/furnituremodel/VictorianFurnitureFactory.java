package com.tss.furnituremodel;

public class VictorianFurnitureFactory implements IFurnitureFactory {
	public IChair createChair() {
		return new VictorianChair();
	}

	public ISofa createSofa() {
		return new VictorianSofa();
	}

	public ITable createTable() {
		return new VictorianTable();
	}
}