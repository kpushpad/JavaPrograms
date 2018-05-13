package com.kpushpad.problem.prodconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class PrintEvenAndOdd {
	public static void main(String args[]) {

		final Queue<Integer> queque = new LinkedList<>();

		Producer producer = new Producer(queque, 1, 10);
		Consumer consumer = new Consumer(queque, 10);

		new Thread(producer, "OddThread").start();
		new Thread(consumer, "EvenThread").start();
	}

}

class Producer implements Runnable {
	private final Queue<Integer> queue;
	private final int quequeSize;
	private final int count;

	Producer(Queue<Integer> queue, int size, int count) {
		this.queue = queue;
		this.quequeSize = size;
		this.count = count;
	}

	@Override
	public void run() {
		int myCount = 1;

		while (true) {
			synchronized (queue) {
				while (queue.size() == quequeSize) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						System.out.println("Excpetion " + e.getMessage());
					}
				}
				queue.add(myCount);
				System.out.println(Thread.currentThread().getName() + " " + myCount);
				queue.notifyAll();
			}

			if (count % 2 != 0 && myCount == count || (myCount + 2) > count) {
				break;
			}
			myCount += 2;

		}
		System.out.println("Bye " + Thread.currentThread().getName());
	}
}

class Consumer implements Runnable {
	private final Queue<Integer> queue;
	private final int count;

	Consumer(Queue<Integer> queue, int count) {
		this.queue = queue;
		this.count = count;
	}

	@Override
	public void run() {

		int myCount = 0;
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						System.out.println("Excpetion " + e.getMessage());
					}
				}
				myCount = queue.poll().intValue();
				queue.notifyAll();
			}
			if (myCount == count) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + " " + (myCount + 1));

			if (count % 2 == 0 && (myCount + 1) == count) {
				break;
			}
		}
		System.out.println("Bye " + Thread.currentThread().getName());
	}
}