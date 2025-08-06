package com.tcs.app;

public class DataAcctTest implements Runnable {

	@Override
	public void run() {
		increment();
		
	}
	
	public synchronized void increment() {
		for(int i=0; i < 5; i++) {
			System.out.println("Data incrementing..........");
			try {
				Thread.sleep(1000); // Simulating a delay for data check
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted: " + e.getMessage());
			}
			
	
	
	}
	
    }

}
