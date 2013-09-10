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
		cur_sum += node.val;
		if(node.left==null && node.right==null){
//			if(cur_sum == sum)
//				System.out.println("return when node val = " + node.val);
			return cur_sum==sum;
		}
		return hasPathSumHelper(node.left, sum, cur_sum) || hasPathSumHelper(node.right, sum, cur_sum);
	}

	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		return hasPathSum((TreeNode)args[0],(Integer)res);
	}
}
