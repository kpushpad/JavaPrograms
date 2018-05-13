
package com.kpushpad.problem.prodconsumer;

/***
 * 
 * @author kpushpad (Kamal Pushpad)
 *
 */
public class MyConsumer implements Runnable {
	private final SharedQueue sharedQ;

	public MyConsumer(SharedQueue sharedQ) {
		this.sharedQ = sharedQ;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			consumeItem();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consumeItem() {
		int item = sharedQ.dequeque();
		System.out.println("Consumed Item: " + item);

	}
}
