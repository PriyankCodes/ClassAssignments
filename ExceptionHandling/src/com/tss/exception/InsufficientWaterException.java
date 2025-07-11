package com.tss.exception;

public class InsufficientWaterException extends RuntimeException{

	private int currentWaterLevel;
	
	public InsufficientWaterException(int currentWaterLevel) {
		super();
		this.currentWaterLevel = currentWaterLevel;
	}

	public String getMessage()
	{
		return "Insufficient Water level in Tank: Current Water Level is : "+currentWaterLevel+" liters";
	}
}
