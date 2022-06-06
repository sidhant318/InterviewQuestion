package MT;


public class ThreadPool {
	
	BlockingQueue<Runnable> queue;

	public ThreadPool(int qSize, int nThread) {
		queue=new BlockingQueue<Runnable>(qSize);
		String threadName=null;
		ThreadExecutor task=null;
		for(int i=0;i<nThread;i++) {
			threadName="Thread-"+i;
			task=new ThreadExecutor(queue);
			Thread thread=new Thread(task, threadName);
			System.out.println("hi---------");
			thread.start();
		}
	}

	public void submitTask(Runnable task) throws InterruptedException {
		queue.enqueue(task);
	}

}
