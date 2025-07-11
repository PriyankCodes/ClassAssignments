package com.tss.structural.facade.model;

public class IndianHotel implements IHotel {

	@Override
	public IMenu getMenu() {
		return new IndianHotel();
	}

	@Override
	public void display() {
		System.out.println("Indian Menu:");
		System.out.println("- Undhiyu");
		System.out.println("- Thepla");
		System.out.println("- Fafda");
		System.out.println("- Kadhi-Khichdi");
	}

}
