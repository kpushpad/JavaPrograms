package com.kpushpad.problem.prodconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
/**
 * @author Kamal Kumar Pushpad
 */

public class SharedQueue {

	private Queue<Integer> queue;
	private int sizeQ;
	private Semaphore isQEmpty;
	private Semaphore emptyBuffer;
	private Semaphore fullBuffer;

	public SharedQueue(int size) {
		this.queue = new LinkedList<Integer>();
		this.sizeQ = size;
		this.isQEmpty = new Semaphore(1, false);
		this.emptyBuffer = new Semaphore(this.sizeQ, false);
		this.fullBuffer = new Semaphore(0, false);
	}

	public void enqueque(int item) {
		try {
			emptyBuffer.acquire();
			isQEmpty.acquire();

			queue.add(item);

			isQEmpty.release();
			fullBuffer.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	 public synchronized  void  lockEnqueque(int item) throws InterruptedException {
		 while(queue.size() == sizeQ)
			 wait();		 
		
		 queue.add(item);
		 
		 notifyAll(); 
	 }
	 
	 public synchronized  int  lockDequeque(int item) throws InterruptedException {
		 while(queue.isEmpty())
			 wait();		 
		
		 item = queue.remove();
		 
		 notifyAll();
		 
		 return item;
	 }
	 
	public int dequeque() {
		int item = 0;
		try {

			fullBuffer.acquire();
			isQEmpty.acquire();

			item = queue.remove();

			isQEmpty.release();
			emptyBuffer.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return item;
	}
}
