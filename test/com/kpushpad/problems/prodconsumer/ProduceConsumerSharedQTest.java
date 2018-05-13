package com.kpushpad.problems.prodconsumer;

import com.kpushpad.problem.prodconsumer.MyConsumer;
import com.kpushpad.problem.prodconsumer.MyProducer;
import com.kpushpad.problem.prodconsumer.SharedQueue;

public class ProduceConsumerSharedQTest {
	private static final int bufferSize = 10;

	public static void main(String[] args) {
		
		SharedQueue queque = new SharedQueue(bufferSize);
		
		Thread produce = new Thread(new MyProducer(queque));
		Thread consumer = new Thread(new MyConsumer(queque));
		consumer.start();
		produce.start();
		
	}

}
