package com.tcs.app;

public class TestAppMain {
    
	public static void main(String[] args) {
		Thread thread1 = new Thread( new DataAcctTest());
		
		Thread thread2 = new Thread(new AcctCheck());
		
		//ac.checkAccountDetails(); // call method from Thread2
		thread1.start();
		thread2.start();
		try {
			thread1.join(); // wait for thread1 to finish
			thread2.join(); // wait for thread2 to finish
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted: " + e.getMessage());
		}
		
		
	}
	}