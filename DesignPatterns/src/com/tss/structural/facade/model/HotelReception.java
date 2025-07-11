package com.tss.structural.facade.model;

public class HotelReception {

	public void getIndianMenu() {
		IHotel indianHotel = new IndianHotel();
		IMenu menu = indianHotel.getMenu();
		menu.display();
	}

	public void getItalianMenu() {
		IHotel italianHotel = new ItalianHotel();
		IMenu menu = italianHotel.getMenu();
		menu.display();
	}

}
