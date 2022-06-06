package Queue;

public class ListQueue {
	
	int[] listQueue;
	int capacity;
	int size;
	
	public ListQueue() {
		this.capacity=10;
		this.size=0;
		listQueue=new int[this.capacity];
	}

	public static void main(String[] args) {
		ListQueue listQueue=new ListQueue();
		listQueue.queue(10);
		listQueue.queue(20);
		listQueue.queue(30);
		listQueue.queue(40);
		listQueue.dequeue();
		listQueue.dequeue();
	}

	private void dequeue() {
		System.out.println("Dequeue : "+listQueue[size-1]);
		size--;
		
	}

	private void print() {
		for(int i=0;i<size;i++) {
			System.out.println(listQueue[i]);
		}
		
	}

	private void queue(int data) {
		for(int i=size;i>0;i--) {
			listQueue[i]=listQueue[i-1];
		}
		listQueue[0]=data;
		size++;
	}

}
