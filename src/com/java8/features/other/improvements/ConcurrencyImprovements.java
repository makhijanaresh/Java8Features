package com.java8.features.other.improvements;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyImprovements {

	
	public static void main(String[] args) {
		Runnable r1=() -> System.out.println("Hello World");
		Thread t1=new Thread(r1);
		t1.start();
		
		ExecutorService executor=Executors.newSingleThreadExecutor();
		executor.submit(()-> {
			
			String threadName=Thread.currentThread().getName();
			System.out.println("Hello :"+threadName);
		});
		
		Callable<String> task=() -> "task 1";
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		Future future=executorService.submit(task);
		
		try
		{
			System.out.println("Value:"+future.get());
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}catch(ExecutionException e)
		{
			e.printStackTrace();
		}
	}
	
}
