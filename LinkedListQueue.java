package Queue;

public class LinkedListQueue {
	
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	Node head,tail;
	
	public LinkedListQueue() {
		this.head=this.tail=null;
	}

	public static void main(String[] args) {
		LinkedListQueue queue=new LinkedListQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

	private void dequeue() {
		if(head==null) {
			System.out.println("Empty List");
			return;
		}
		System.out.println("Dequeue is : " +head.data);
		head=head.next;
	}

	private void print() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
		
	}

	private void enqueue(int data) {
		Node n=new Node(data);
		if(head==null) {
			head=tail=n;
			return;
		}
		tail.next=n;
		tail=n;
	}

}
