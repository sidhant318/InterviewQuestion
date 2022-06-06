package Tree;

import Tree.BST.Node;

public class BSTNoLeaf {
	
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
		BSTNoLeaf b=new BSTNoLeaf();
		b.add(5);
		b.add(3);
		b.add(4);
		//b.add(2);
		b.add(7);
		b.leaf();

	}
	
	private void leaf() {
		int count=leaf(root);
		System.out.println(count);
	}

	private int leaf(Node root2) {
		if(root2==null)
			return 0;
		if(root2.left==null || root2.right==null)
			return 1;
		return leaf(root2.left)+leaf(root2.right);
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
