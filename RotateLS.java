package LinkedList;

import LinkedList.ReverseLS.Node;

public class RotateLS {

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
		RotateLS linkedList=new RotateLS();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.print();
		System.out.println();
		linkedList.rotate(3);
		linkedList.print();
		
	}
	
	//5-4-3-2-1
	//2-1-5-4-3
	
	private void rotate(int k) {
		Node current=head;
		int size=1;
		while(current!=null && size<k) {
			current=current.next;
			size++;
		}
		Node Kth=current;
		while(current.next!=null) {
			current=current.next;
		}
		current.next=head;
		head=Kth.next;
		Kth.next=null;
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
