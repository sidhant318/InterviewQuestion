package MT;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompatableFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(" ---" +Thread.currentThread().getName());
		CompletableFuture<Void> future =getcall();
//		ExecutorService e=Executors.newFixedThreadPool(4);
//		e.submit(task)
	}

	private static CompletableFuture<Void> getcall() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
	//	CompletableFuture.
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->
		{
			System.out.println(Thread.currentThread().getName());
			//System.out.println("hii");
			return "apple";
		});
		
		CompletableFuture.runAsync(()->
		{
			System.out.println(Thread.currentThread().getName());
			//System.out.println("hii");
			//return "apple";
		});
		
		
		System.out.println(completableFuture.get());
		return null;
	}
}
