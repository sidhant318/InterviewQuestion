package MT;

public class SynExmple1 {

	public static int count=0;
	
	public static void process() {
		Thread t1=new Thread(()-> {
			for(int i=0;i<1000;i++)
					inc();
		});
		Thread t2=new Thread(()-> {
			for(int i=0;i<1000;i++)
					inc();
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private static synchronized void inc() {
		++count;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
process();
System.out.println(count);
	}

}