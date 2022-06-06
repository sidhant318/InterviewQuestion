package Tree;

public class TreeSubTree {

	public static void main(String[] args) {
		TreeSubTree t=new TreeSubTree();
		TreeNode a=new TreeNode(1);
		a.left=new TreeNode(2);
		a.right=new TreeNode(3);
		a.left.left=new TreeNode(4);
		a.left.right=new TreeNode(5);
		a.right.left=new TreeNode(6);
		a.right.right=new TreeNode(7);
		
		boolean bo=t.subTree(a,a.right);
		System.out.println("Tree is mirror : "+bo);

	}

	private boolean subTree(TreeNode a, TreeNode b) {
		if(b==null)
			return true;
		if(a==null)
			return false;
		
		if(isMirror(a,b))
			return true;
		
		return (subTree(a.left,b) || subTree(a.right, b));
	}

	private boolean isMirror(TreeNode a, TreeNode b) {
		if(a==null && b==null)
			return true;
		if(a!=null && b!=null && a.data==b.data) {
			return (isMirror(a.left,b.left) && isMirror(a.right, b.right));
		}
		return false;
	}

}
