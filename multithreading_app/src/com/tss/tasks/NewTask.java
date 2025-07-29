package com.tss.tasks;

import java.util.Random;
import java.util.concurrent.Callable;

public class NewTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		Random random = new Random();
		return random.nextInt();
	}

}
