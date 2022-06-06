package Tree;

public class BSTHeight {
	
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
		BSTHeight b=new BSTHeight();
		b.add(2);
		b.add(1);
		b.add(8);
		b.add(9);
		b.add(6);
		b.add(4);
		b.add(7);
		b.height();

	}
	
	/*
	 *       5
	 *    3    7
	 *  2   4
	 * 1
	 * */
	
	private void height() {
		int height=height(root);
		System.out.println("Height of BST is : "+height);
	}

	private int height(Node root2) {
		if(root2==null)
			return 0;
		int lheight=height(root2.left)+1;
		int rheight=height(root2.right)+1;
		return Math.max(lheight, rheight);
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
