package Tree;

public class FloorCeil {
	
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
		FloorCeil ceil=new FloorCeil();
		ceil.add(5);
		ceil.add(3);
		ceil.add(4);
		ceil.add(2);
		ceil.add(8);
		ceil.add(7);
		ceil.add(9);
		ceil.ceilValue(6);
		//ceil.floorValue();
	}
	
	private void ceilValue(int data) {
		int val=ceilValue(root,data);
		System.out.println(val);
	}

	private int ceilValue(Node root2,int n) {
		int ceil=Integer.MAX_VALUE;
		while(root2!=null) {
			if(root2.data==n)
				return root2.data;
			if(root2.data>n) {
				ceil=root2.data;
				root2=root2.left;
			}
			else {
				root2=root2.right;
			}
		}
		return ceil;
	}

	private void print() {
		print(root);
		
	}

	private void print(Node root2) {
		if(root2==null)
			return;
		print(root2.left);
		System.out.println(root2.data);
		print(root2.right);
	}

	private void add(int i) {
		root=add(i,root);
		
	}

	private Node add(int i, Node root2) {
		Node n=new Node(i);
		if(root2==null)
			return n;
		if(root2.data>i)
			root2.left=add(i,root2.left);
		else
			root2.right=add(i,root2.right);
		return root2;
	}

}
