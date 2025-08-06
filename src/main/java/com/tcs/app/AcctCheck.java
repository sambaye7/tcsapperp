package com.tcs.app;

public class AcctCheck implements Runnable {
	
	@Override
	public void run() {
		for(int i=0; i < 5; i++) {
			System.out.println("Account check..........");
			 try {
				Thread.sleep(1000); // Simulating a delay for account check
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted: " + e.getMessage());
			}
			 
		
		}
	}
	

}
