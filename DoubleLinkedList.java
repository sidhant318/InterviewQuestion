package LinkedList;

public class DoubleLinkedList {
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data=data;
			this.next=this.prev=null;
		}
	}
	
	Node head;

	public static void main(String[] args) {
		DoubleLinkedList d=new DoubleLinkedList();
		d.add(1);
		d.add(2);
		d.add(3);
		d.append(4);
		d.append(5);
		d.add(6);
		d.delete(6);
		d.add(3);
		d.append(4);
		d.print();
	}

	private void delete(int i) {
		if(head==null)
			return;
		if(head.data==i)
			head=head.next;
		
		Node tmp=head;
		while(tmp!=null && tmp.data!=i) {
			tmp=tmp.next;
		}
		if(tmp==null)
			return;

		if(tmp.next!=null)
			tmp.next.prev=tmp.prev;
		
		if(tmp.prev!=null)
			tmp.prev.next=tmp.next;
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
		n.prev=tmp;
		tmp.next=n;
	}

	private void print() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
	}

	private void add(int data) {
		Node n=new Node(data);
		n.next=head;
		if(head!=null)
			head.prev=n;
		head=n;
	}

}
