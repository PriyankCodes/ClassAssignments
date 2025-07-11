package com.tss.model;

import com.tss.exception.InsufficientWaterException;
import com.tss.exception.OverfillException;

public class WaterDispenser {

	private int maxCapacity = 100;
	private int currentWaterLevel = 0;

	public int fillWater(int water) {
		if ((currentWaterLevel + water) > maxCapacity) {
			throw new OverfillException((maxCapacity-currentWaterLevel));
		}
		currentWaterLevel += water;
		return currentWaterLevel;
	}

	public int dispenseWater(int water) {
		if ((currentWaterLevel - water) < 0) {
			throw new InsufficientWaterException(currentWaterLevel);
		}
		currentWaterLevel -= water;
		return currentWaterLevel;
	}
}
