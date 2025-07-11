package com.tss.exception;

public class OverfillException extends RuntimeException {
	
	private int remainingCapacity;

	public OverfillException(int remainingCapacity) {
		super();
		this.remainingCapacity = remainingCapacity;
	}
	
	public String getMessage()
	{
		return "Attempted to OverFill Water Tank: Remaining Capacity is : "+remainingCapacity+" liters";
	}

}
