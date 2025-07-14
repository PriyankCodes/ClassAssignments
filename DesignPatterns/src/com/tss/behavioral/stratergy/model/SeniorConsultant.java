package com.tss.behavioral.stratergy.model;

public class SeniorConsultant implements IRole {

	@Override
	public String getDescription() {
		return "Review code";
	}

	@Override
	public String getResponsibility() {
		return "Code review and mentorship";
	}
}