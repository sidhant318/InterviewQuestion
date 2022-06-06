package LinkedList;

public class ReverseLS {
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;

	public static void main(String[] args) {
		ReverseLS linkedList=new ReverseLS();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.print();
		System.out.println();
		linkedList.reverse();
		linkedList.print();
		
	}
	
	
	private void reverse() {
		Node current=head;
		Node next=null,prev=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}

	private void print() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
	}
	
	private void add(int i) {
		Node n=new Node(i);
		if(head==null) {
			head=n;
			return;
		}
		n.next=head;
		head=n;
	}

}
