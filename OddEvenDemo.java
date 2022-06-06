package MT;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenDemo implements Runnable{
	
	int reminder;
	int noOfThread;
	static int count=0;
	private static int size=20;
	
	public OddEvenDemo(int reminder,int noOfThread) {
		this.reminder=reminder;
		this.noOfThread=noOfThread;
	}

	public static void main(String[] args) {
		int noOfThread=3;
		ExecutorService e=Executors.newFixedThreadPool(noOfThread);
		for(int i=0;i<noOfThread;i++) {
			e.submit(new OddEvenDemo(i,noOfThread));
		}
	}

	private void print() {
		while(count<size) {
			synchronized (OddEvenDemo.class) {
				while(count%noOfThread!=reminder) {
					try {
						OddEvenDemo.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(count+" "+Thread.currentThread().getName());
				count++;
				OddEvenDemo.class.notifyAll();
			}
		}
	}

	@Override
	public void run() {
		print();	
	}

}
