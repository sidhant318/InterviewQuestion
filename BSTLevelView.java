package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTLevelView {
	
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
		BSTLevelView b=new BSTLevelView();
		b.add(5);
		b.add(3);
		b.add(4);
		b.add(2);
		b.add(7);
		b.add(1);
		System.out.println("Level View");
		b.LevelView();
	}

	private void LevelView() {
		LevelView(root);
		
	}

	private void LevelView(Node root2) {
		Queue<Node> q=new LinkedList();
		q.add(root2);
		while(q.size()>0) {
			Node tmp=q.remove();
			System.out.println(tmp.data);
			if(tmp.left!=null)
				q.add(tmp.left);
			if(tmp.right!=null)
				q.add(tmp.right);
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
