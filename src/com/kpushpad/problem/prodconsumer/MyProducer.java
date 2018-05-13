package com.kpushpad.problem.prodconsumer;

/***
 * 
 * @author kpushpad (Kamal Pushpad)
 *
 */

public class MyProducer implements Runnable {
	private SharedQueue sharedQ;

	public MyProducer(SharedQueue sharedQ) {
		this.sharedQ = sharedQ;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			produceItem();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produceItem() {
		int random = (int) (Math.random() * 50 + 1);
		sharedQ.enqueque(random);
		System.out.println("Produced item: " + random);
	}
}
