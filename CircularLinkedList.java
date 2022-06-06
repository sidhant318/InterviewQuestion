package LinkedList;

public class CircularLinkedList {
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;
	Node reer;

	public static void main(String[] args) {
		CircularLinkedList c=new CircularLinkedList();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.append(5);
		c.append(6);
		c.add(7);
		c.delete(1);
		c.print();

	}

	private void delete(int i) {
		if(head==null)
			return;
		if(head.data==i) {
			head=head.next;
			reer.next=head;
			return;
		}
		Node tmp=head.next;
		Node prev=head;
		while(tmp!=head && tmp.data!=i) {
			prev=tmp;
			tmp=tmp.next;
		}
		prev.next=tmp.next;
		if(tmp.next==head)
			reer=prev;
	}

	private void append(int i) {
		Node n=new Node(i);
		if(head==null) {
			head=reer=n;
			n.next=head;
			return;
		}
		reer.next=n;
		reer=n;
		n.next=head;
	}

	private void add(int i) {
		Node n=new Node(i);
		if(head==null) {
			head=reer=n;
			n.next=head;
			return;
		}
		
		n.next=head;
		reer.next=n;
		head=n;
	}

	private void print() {
		if(head==null)
			return;
		Node tmp=head;
		do {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
		while(tmp!=head);
	}

}
