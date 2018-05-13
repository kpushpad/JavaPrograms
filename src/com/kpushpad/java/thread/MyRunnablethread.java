package com.kpushpad.java.thread;

public class MyRunnablethread implements Runnable {

	@Override
	public void run() {
		
		try {
			System.out.println("Thread"+ Thread.currentThread().getName() + "started");
			Thread.sleep(1000*5);
			System.out.println("Thread"+ Thread.currentThread().getName() + "done");
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	public static void main(String args[]) {

		Thread t1 = new Thread(new MyRunnablethread(), "t1");
		t1.setPriority(8);
		
		Thread t2 = new Thread(new MyRunnablethread(), "t2");
		t2.setPriority(6);
		
		Thread t3 = new Thread(new MyRunnablethread(), "t3");
		t3.setPriority(7);
		
		Thread t4 = new Thread() {
			public void run() {

				try {
					System.out.println("Thread" + Thread.currentThread().getName() + "started");
					Thread.sleep(1000 * 5);
					System.out.println("Thread" + Thread.currentThread().getName() + "done");
				} catch (InterruptedException e) {
					e.getMessage();
				}
			}
		};
		
		Runnable r = () -> {System.out.println("Thread" + Thread.currentThread().getName() + "started");};
		
		Thread t5 = new Thread(r);
		Thread t6 = new Thread( () -> System.out.println("kamal"));
		
		t4.start();
        t1.start();
        t2.start();
        t3.start();
	}

}