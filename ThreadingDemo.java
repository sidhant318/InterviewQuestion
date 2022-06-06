package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Demo implements Callable<Integer>{
	
	static int count=0;

	@Override
	public Integer call() {	
		System.out.println(Thread.currentThread().getName());
		return ++count;
	}
	
}

class Demo1 implements Callable<Integer>{
	
	static int count=0;

	@Override
	public Integer call() throws InterruptedException {
		int a=2/0;
		System.out.println(Thread.currentThread().getName());
		return ++count;
	}
	
}
public class ThreadingDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo d=new Demo();
		Demo1 d1=new Demo1();
		ExecutorService es=Executors.newFixedThreadPool(4);
		//IntStream.range(0, 10).forEach(x->);
		List<Future<Integer>> list=new ArrayList<Future<Integer>>();
		for(int i=0;i<4;i++) {
			if(i==1) {
				Future<Integer> f=es.submit(()->d1.call());
				list.add(f);
			}
			else {
				Future<Integer> f=es.submit(()->d.call());
				list.add(f);
			}
			
		}
		//List<Future<Integer>> lists=new ArrayList<Future<Integer>>();
		System.out.println("size is : "+list.size());
		for(Future<Integer> f:list) {
			//if(f.isDone())
				System.out.println(f.get());
			
		}
		
	}

}
