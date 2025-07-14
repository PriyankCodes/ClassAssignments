package com.tss.dip;

public class DBLogger1 implements ILogger {
	@Override
	public void log(String err) {
		System.out.println("DBLogger: Logged to database -> " + err);
	}
}