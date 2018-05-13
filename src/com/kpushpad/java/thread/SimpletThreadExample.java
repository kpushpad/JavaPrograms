package com.kpushpad.java.thread;

public class SimpletThreadExample {
	public static void main(String args[]) {

		MyThreadNew o = new MyThreadNew("Test");
		
		Thread myThread = new Thread(o);
		myThread.start();
		
		new Thread(new Runnable () {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("Hello world 2");
			}
			
		}).start();
		
		new Thread( ()  ->  {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Hello world 2");		
		}).start();

	}
}

class MyThreadNew implements Runnable {
	private final String name;

	MyThreadNew(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(name + " Hello world");
	}
}


