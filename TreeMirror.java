package Tree;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data=data;
		this.left=this.right=null;
	}
}

public class TreeMirror {

	public static void main(String[] args) {
		TreeMirror t=new TreeMirror();
		TreeNode a=new TreeNode(1);
		TreeNode b=new TreeNode(1);
		a.left=new TreeNode(2);
		a.right=new TreeNode(3);
		a.left.left=new TreeNode(4);
		a.left.right=new TreeNode(5);
		
		b.left=new TreeNode(3);
		b.right=new TreeNode(2);
		b.right.left=new TreeNode(5);
		b.right.right=new TreeNode(4);
		
		boolean bo=t.mirror(a,b);
		System.out.println("Tree is mirror : "+bo);
	}

	private boolean mirror(TreeNode a, TreeNode b) {
		if(a==null && b==null)
			return true;
		if(a!=null && b!=null && a.data==b.data) {
			return (mirror(a.left,b.right) && mirror(a.right,b.left));
		}
		return false;
	}


}
