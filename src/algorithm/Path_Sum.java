package algorithm;

import util.TreeNode;
import program.*;

public class Path_Sum implements Testable{
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		return hasPathSumHelper(root,sum,0);
	}
	
	public boolean hasPathSumHelper(TreeNode node, int sum, int cur_sum){
		if(node==null)
			return false;
		String left = (node.left==null)?"null":String.valueOf(node.left.val);
		String right = (node.right==null)?"null":String.valueOf(node.right.val);
//		System.out.println("node val = " + node.val+", node left = " + left + " and node right = "+ right);
//		System.out.println("cur_sum = " + cur_sum);
		cur_sum += node.val;
		if(node.left==null && node.right==null){
//			if(cur_sum == sum)
//				System.out.println("return when node val = " + node.val);
			return cur_sum==sum;
		}
		return hasPathSumHelper(node.left, sum, cur_sum) || hasPathSumHelper(node.right, sum, cur_sum);
	}

	@Override
	public boolean test(Object a, int b) {
		// TODO Auto-generated method stub
		return hasPathSum((TreeNode)a,b);
	}
}
