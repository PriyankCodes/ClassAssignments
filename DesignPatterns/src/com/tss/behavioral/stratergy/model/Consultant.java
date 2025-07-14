package com.tss.behavioral.stratergy.model;

public class Consultant implements IRole {

	@Override
	public String getDescription() {
		return "Write code";
	}

	@Override
	public String getResponsibility() {
		return "Coding features and fixing bugs";
	}
}