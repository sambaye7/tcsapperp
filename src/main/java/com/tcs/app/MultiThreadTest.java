package com.tcs.app;

// Example of multithreading in Java
// Thread1 extends Thread, Thread2 implements Runnable
public class MultiThreadTest {
    // Thread by extending Thread class
    static class Thread1 extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread1: " + i);
                try {
                    Thread.sleep(500); // pause for 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Thread by implementing Runnable interface
    static class Thread2 implements Runnable {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread2: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread t2 = new Thread(new Thread2());
        t1.start(); // start Thread1
        t2.start(); // start Thread2
        
        try {
			t1.join(); // wait for Thread1 to finish
			t2.join(); // wait for Thread2 to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}