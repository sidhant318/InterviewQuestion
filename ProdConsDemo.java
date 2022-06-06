package MT;

import java.util.ArrayList;

public class ProdConsDemo {
	
	ArrayList<Integer> al=new ArrayList<>();
	private static final Integer LIMIT=5;
	private static final Integer MIN=0;
	
	Integer val=0;
	
	public void produce() throws InterruptedException {
		while(true) {
			synchronized (this) {
				if(al.size()==LIMIT) {
					wait();
				}
				al.add(val);
				System.out.println("Value Added "+val);
				val++;
				notify();
				Thread.sleep(1000);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (this) {
				if(al.size()==MIN) {
					wait();
				}
				val--;
				System.out.println("Value Removed "+val);
				al.remove(val);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public static void main(String[] args) {
		ProdConsDemo pd=new ProdConsDemo();
		Thread t=new Thread(()->{
			try {
				pd.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t1=new Thread(()-> {
			try {
				pd.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t.start();
		t1.start();
		System.out.println("DONE");
	}

}
