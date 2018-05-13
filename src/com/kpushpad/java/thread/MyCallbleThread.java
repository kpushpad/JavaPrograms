package com.kpushpad.java.thread;

import java.util.concurrent.Callable;

public class MyCallbleThread implements Callable<Integer> {
	private int a;
	private int b;
	
	MyCallbleThread(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		
		return this.a + this.b;
	}

}
