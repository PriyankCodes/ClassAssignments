package com.tss.structural.adapter.model;

public class HatAdapter implements IItems {

	private Hat hat;

	public HatAdapter(Hat hat) {
		this.hat = hat;
	}

	@Override
	public String getItemName() {
		return hat.getShortName() + hat.getLongName();
	}

	@Override
	public double getItemPrice() {
		return hat.getPrice() - (hat.getPrice() * hat.getDiscount() / 100.0);
	}
}
