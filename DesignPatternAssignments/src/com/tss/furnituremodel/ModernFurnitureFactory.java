package com.tss.furnituremodel;

public class ModernFurnitureFactory implements IFurnitureFactory {
	public IChair createChair() {
		return new ModernChair();
	}

	public ISofa createSofa() {
		return new ModernSofa();
	}

	public ITable createTable() {
		return new ModernTable();
	}
}
