package com.tss.creational.builder.test;

import com.tss.creational.builder.model.Computer;
import com.tss.creational.builder.model.ComputerBuilder;

public class BuilderTest {
	public static void main(String[] args) {
		Computer gamingPC = new ComputerBuilder().setCPU("Intel i9").setRAM("32GB").setStorage("1TB SSD")
				.setGraphicsEnabled(true).build();

		System.out.println(gamingPC);

		Computer officePC = new ComputerBuilder().setCPU("Intel i5").setRAM("8GB").setStorage("500GB HDD")
				.setGraphicsEnabled(false).build();

		System.out.println(officePC);

	}
}
