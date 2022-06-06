package Tree;

public class BSTNodeCount {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	Node root;

	public static void main(String[] args) {
		BSTNodeCount b=new BSTNodeCount();
		b.add(5);
		b.add(3);
		b.add(4);
		b.add(2);
		b.add(7);
		b.add(1);
		b.count();

	}
	
	private void count() {
		int count=count(root);
		System.out.println("Total Number of Node is : "+count);
	}

	private int count(Node root2) {
		if(root2==null)
			return 0;
		int lcount=count(root2.left);
		int rcount=count(root2.right);
		return lcount+rcount+1;
	}

	private void add(int i) {
		root=add(i,root);	
	}

	private Node add(int i, Node root2) {
		if(root2==null)
			return new Node(i);
		if(i>root2.data) {
			root2.right=add(i,root2.right);
		}
		else {
			root2.left=add(i,root2.left);
		}
		return root2;
	}

}
