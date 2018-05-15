package tree;

public class TreeNode {
	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	private Integer data;
	
	public TreeNode (TreeNode par, Integer val ) {
		this.parent = par;
		this.data = val;
	}
	
	public TreeNode addLeft ( Integer val ) {
		this.left = new TreeNode(this.parent, val);
		return this.left;
	}
	
	public TreeNode addRight ( Integer val ) {
		this.right = new TreeNode(this.parent, val);
		return this.right;
	}
	
	public TreeNode left () {
		return this.left;
	}
	
	public TreeNode right () {
		return this.right;
	}
	
	public Integer getData () {
		return this.data;
	}
	
}
