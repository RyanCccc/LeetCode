package algorithm;

import java.util.LinkedList;

import util.TreeNode;
import program.*;

public class Min_Depth extends Testable {
	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int cur_child = 1;
		int nxt_child = 0;
		int level = 1;
		TreeNode node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			cur_child--;
			if (node.left != null) {
				queue.add(node.left);
				nxt_child++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nxt_child++;
			}
			if (node.right == null && node.left == null) {
				return level;
			}
			if (cur_child == 0) {
				// End level
				level++;
				cur_child = nxt_child;
				nxt_child = 0;
			}
		}
		return 0;
	}

	@Override
	public boolean test(Object node, Object res) {
		// TODO Auto-generated method stub
		return minDepth((TreeNode)node) == (Integer)res;
	}
}
