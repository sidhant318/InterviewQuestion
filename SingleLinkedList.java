package LinkedList;

public class SingleLinkedList {
	
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
		SingleLinkedList linkedList=new SingleLinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.append(3);
		linkedList.delete();
		linkedList.deleteLast();
		linkedList.add(3);
		linkedList.add(4);
		linkedList.print();
	}

	

	private void print() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
		
	}



	private void deleteLast() {
		if(head==null)
			return;
		Node tmp=head;
		Node prev=null;
		if(tmp.next!=null) {
			prev=tmp;
			tmp=tmp.next;
		}
		if(prev==null)
			head=null;
		prev.next=null;
	}

	private void delete() {
		if(head==null)
			return;
		head=head.next;
	}

	private void append(int i) {
		Node n=new Node(i);
		if(head==null) {
			head=n;
			return;
		}
		Node tmp=head;
		while(tmp.next!=null) {
			tmp=tmp.next;
		}
		tmp.next=n;
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
