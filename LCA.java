package Tree;

public class LCA {
	
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
		LCA l=new LCA();
		l.add(5);
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(8);
		l.add(7);
		l.add(9);
		//l.print();
		l.lca(2,9);
		System.out.println();
	}

	private void lca(int i, int j) {
		Node data=lca(root,i,j);
		System.out.println(data.data);
	}

	private Node lca(Node root2, int a, int b) {
		if(root2==null)
			return root2;
		if(root2.data==a || root2.data==b)
			return root2;
		Node left=lca(root2.left,a,b);
		Node right=lca(root2.right,a,b);
		if(left==null)
			return right;
		if(right==null)
			return left;
		return root2;
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
