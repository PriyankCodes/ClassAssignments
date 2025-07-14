package com.tss.behavioral.stratergy.model;

public class TechLead implements IRole {

	@Override
	public String getDescription() {
		return "Design work";
	}

	@Override
	public String getResponsibility() {
		return "System architecture and task planning";
	}
}
