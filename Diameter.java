package Tree;

public class Diameter {
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
		Diameter l=new Diameter();
		l.add(5);
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(8);
		l.add(7);
		l.add(9);
		l.diameter();
	}

	private void diameter() {
		int val=diameter(root);
		System.out.println(val);
		System.out.println(ans);
	}
	int ans=0;
	private int diameter(Node root2) {
		if(root2==null)
			return 0;
		int lh=diameter(root2.left);
		int rh=diameter(root2.right);
		ans=Math.max(ans, 1+lh+rh);
		return Math.max(lh, rh)+1;
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
