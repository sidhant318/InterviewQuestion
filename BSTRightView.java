package Tree;

public class BSTRightView {
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
		BSTRightView b=new BSTRightView();
		b.add(5);
		b.add(3);
		b.add(4);
		b.add(2);
		b.add(7);
		b.add(1);
		System.out.println("Right View");
		b.rightView();
	}
	
	private void rightView() {
		rightView(root,1);
	}
	
	int maxLevel=0;

	private void rightView(Node root2, int level) {
		if(root2!=null) {
			if(maxLevel<level) {
				System.out.println(root2.data);
				maxLevel++;
			}
			rightView(root2.right,level+1);
			rightView(root2.left,level+1);
		}
		
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
