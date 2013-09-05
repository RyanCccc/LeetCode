package util;

public class TreeNode {
	public int val;
	public TreeNode left=null;
	public TreeNode right=null;
	public TreeNode(int x) { val = x; }
	
	public String toString(){
		return String.valueOf(this.val) + " ";
	}
}
