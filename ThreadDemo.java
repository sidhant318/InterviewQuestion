package MT;

class MyTask implements Runnable {
	@Override
	public void run() {
		System.out.println("Starting MyTask...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending MyTask...");
	}
}


public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		int noOfThread=5;
		int qSize=10;
		ThreadPool t=new ThreadPool(qSize, noOfThread);
		for(int i=0;i<5;i++) {
			MyTask m=new MyTask();
			t.submitTask(m);
		}
	}

}
