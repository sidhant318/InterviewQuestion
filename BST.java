package Tree;

public class BST {
	
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
		BST b=new BST();
		b.add(5);
		b.add(3);
		b.add(4);
		b.add(2);
		b.add(7);
		b.delete(5);
		b.print();
	}
	
	/*
	 *       5
	 *    3    7
	 *  2   4
	 * 
	 * */

	private void print() {
		print(root);
		
	}

	private void print(Node root2) {
		if(root2!=null) {
			print(root2.left);
			System.out.println(root2.data);
			print(root2.right);	
		}
	}

	private void delete(int i) {
		root=delete(i,root);
	}

	private Node delete(int data, Node root2) {
		if(root2==null)
			return root2;
		if(data>root2.data) {
			root2.right=delete(data, root2.right);
		}
		else if(data<root2.data) {
			root2.left=delete(data, root2.left);
		}
		else {
			if(root2.left==null || root2.right==null) {
				Node tmp=root2.left==null?root2.right:root2.left;
				return tmp;
			}
			Node suc=getSuccessor(root2.right);
			root2.data=suc.data;
			root2.right=delete(suc.data,root2.right);
		}
		return root2;
	}

	private Node getSuccessor(Node right) {
		Node tmp=right;
		while(tmp.left!=null) {
			tmp=tmp.left;
		}
		return tmp;
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
