package com.kpushpad.java.thread;

public class NeverTerminateThread {

	public static void main(String args[]) {
		new Thread(() -> {
			System.out.println("Name: " + Thread.currentThread().getName());
			System.out.println("I will never Let JVM terminate");
			while (true);
		}, "TestThread").start();

		System.out.println("Name: " + Thread.currentThread().getName());
	}
}
