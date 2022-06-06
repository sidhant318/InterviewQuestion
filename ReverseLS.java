package Recursion;

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
		//linkedList.print();
		//System.out.println();
		linkedList.reverse();
		linkedList.print();
		
	}
	
	private void reverse() {
		head=reverse(head);
	}

	private Node reverse(Node tmp) {
		if(tmp==null)
			return tmp;
		if(tmp.next==null)
			return tmp;
		Node n=reverse(tmp.next);
		tmp.next.next = tmp;
		tmp.next = null;
		return n;
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
