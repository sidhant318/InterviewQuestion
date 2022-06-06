package LinkedList;
public class MergeTwoLS {

	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;
	
	public static void main(String[] args) {
		MergeTwoLS mergeTwoLS1=new MergeTwoLS();
		MergeTwoLS mergeTwoLS2=new MergeTwoLS();
		mergeTwoLS1.add(6);
		mergeTwoLS1.add(4);
		mergeTwoLS1.add(2);
		mergeTwoLS1.print();
		mergeTwoLS2.add(5);
		mergeTwoLS2.add(3);
		mergeTwoLS2.add(1);
		mergeTwoLS2.print();
		Node tmp=sort(mergeTwoLS1.head,mergeTwoLS2.head);
		print(tmp);
	}
	
	private static MergeTwoLS.Node sort(Node head2, Node head3) {
		Node tail=new Node(0);
		Node aux=tail;
	     Node tmp1=head2;
	     Node tmp2=head3;
	     while(tmp1!=null && tmp2!=null){
	         if(tmp1.data>=tmp2.data){
	            aux.next=tmp2;
	             tmp2=tmp2.next;
	         }
	         else{
	            aux.next=tmp1;
	            tmp1=tmp1.next;
	         }
	         aux=aux.next;
	     }
	     if(tmp1!=null) {
	    	 aux.next=tmp1;
	     }
	     if(tmp2!=null) {
	    	 aux.next=tmp2;
	     }
	     return tail.next;
	}

	private static void print(Node tmp) {
		while(tmp!=null) {
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
		System.out.println();
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
	
	private void print() {
		Node tmp=head;
		while(tmp!=null) {
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
		System.out.println();
	}

}
