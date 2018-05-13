package com.kpushpad.java.thread;


class MyThread implements Runnable {
	private String name;
	
	MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		Thread currentThread = Thread.currentThread();
		while (!currentThread.isInterrupted()) {
			System.out.println(Thread.currentThread().getName() + " Hello " + name);
			try {
				Thread.sleep(1000 * 2);
			} catch (InterruptedException e) {
				currentThread.interrupt();
			}
		}
		throw new  RuntimeException("I am dying and throwing exceptiob");
	}

}
public class MyTestThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread("kamal"));
		
		t1.start();
//		new Thread(new MyThread("kailash")).start();
//		new Thread(new MyThread("pawan")).start();
		try {
			Thread.currentThread().sleep(1000 * 10);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		t1.interrupt();
		
	}

}
