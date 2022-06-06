package Tree;

import java.util.Map.Entry;
import java.util.TreeMap;

public class BSTBottomView {

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
		BSTBottomView b=new BSTBottomView();
		b.add(2);
		b.add(1);
		b.add(8);
		b.add(9);
		b.add(6);
		b.add(4);
		b.add(7);
		System.out.println("Level View");
		b.bottomView();

	}
	
	private void bottomView() {
		TreeMap<Integer,Node> map=bottomView(root,new TreeMap<>(),0);
		for(Entry<Integer, Node> m:map.entrySet()) {
			System.out.println(m.getValue().data);
		}
	}

	private TreeMap<Integer,Node> bottomView(Node root2,TreeMap<Integer,Node> map,int height) {
		if(root2==null)
			return map;
		map.put(height, root2);
		if(root2.left!=null)
			bottomView(root2.left,map,height-1);
		if(root2.right!=null)
			bottomView(root2.right,map,height+1);
		return map;
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
