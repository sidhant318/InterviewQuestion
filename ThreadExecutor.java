package MT;

public class ThreadExecutor implements Runnable{
	BlockingQueue<Runnable> queue;
	
	ThreadExecutor(BlockingQueue<Runnable> queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		try {
			while(true) {
				String name=Thread.currentThread().getName();
				Runnable task=queue.dequeue();
				System.out.println(name);
				System.out.println("Test Started ...");
				task.run();
				System.out.println("Test Finished ...");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

