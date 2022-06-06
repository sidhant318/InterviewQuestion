package MT;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	private Queue<T> queue=new LinkedList<T>();
	private int EMPTY=0;
	private int MAX_SIZE=-1;
	BlockingQueue(int qsize){
		this.MAX_SIZE=qsize;
	}
	public synchronized void enqueue(T task) throws InterruptedException {
		while(this.queue.size()==this.MAX_SIZE) {
			wait();
		}
		if(this.queue.size()==this.EMPTY) {
			notifyAll();
		}
		queue.offer(task);
	}
	public synchronized T dequeue() throws InterruptedException {
		while(this.queue.size()==this.EMPTY) {
			wait();
		}
		if(this.queue.size()==this.MAX_SIZE) {
			notifyAll();
		}
		return queue.poll();
	}

}
