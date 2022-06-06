package Tree;

import Tree.BST.Node;

public class isBST {
	
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
		isBST b=new isBST();
		b.add(5);
		b.add(3);
		b.add(4);
		b.add(2);
		b.add(7);
		b.check();
		

	}
	
	private void check() {
		boolean che=check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println("Is BST : "+che);
	}

	private boolean check(Node root2, int min,int max) {
		if(root2==null)
			return true;
		if(root2.data<=min || root2.data>=max)
			return false;
		return (check(root2.left,min,root2.data) && check(root2.right,root2.data,max));
		
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
