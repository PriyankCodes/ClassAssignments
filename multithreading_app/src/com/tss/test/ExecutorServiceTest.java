package com.tss.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tss.tasks.NewTask;

public class ExecutorServiceTest {

	public static void main(String[] args) {

		ExecutorService service = null;
		try {
			List<NewTask> tasks = Arrays.asList(new NewTask(), new NewTask(), new NewTask(), new NewTask(),
					new NewTask());

			service = Executors.newSingleThreadExecutor();

			// Future<Integer> future = service.submit(new NewTask());

			// int value = service.invokeAny(tasks);

			List<Future<Integer>> futures = service.invokeAll(tasks);

			for (Future<Integer> future : futures) {
				System.out.println(future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();

	}

}
