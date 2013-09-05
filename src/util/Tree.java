package util;

import java.util.concurrent.*;

public class Tree {
	public static void printTree(TreeNode root) {
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(root);
		TreeNode node = null;
		int cur_child = 1;
		int nxt_child = 0;
		TreeNode NULL = new TreeNode(Integer.MIN_VALUE);
		while (!queue.isEmpty()) {
			node = queue.poll();
			if(node.val==Integer.MIN_VALUE){
				System.out.print("# ");
				continue;
			}
			cur_child--;
			System.out.print(node);

			if (node.left != null) {
				queue.add(node.left);
				nxt_child++;
			}else{
				queue.add(NULL);
			}
			if (node.right != null) {
				queue.add(node.right);
				nxt_child++;
			}else{
				queue.add(NULL);
			}
			if (cur_child == 0) {
				System.out.println();
				cur_child = nxt_child;
				nxt_child = 0;
			}
		}
	}

	public static TreeNode generateTree(int[] T) {
		int[] new_T = new int[T.length + 1];
		new_T[0] = 0;
		for (int i = 0; i < T.length; i++) {
			new_T[i + 1] = T[i];
		}
		return generateTreeHelper(new_T, 1);
	}

	public static TreeNode generateTreeHelper(int[] T, int index) {
		if (T.length == 0)
			return null;
		if (index >= T.length)
			return null;
		if(T[index]==Integer.MIN_VALUE)
			return null;
		TreeNode root = new TreeNode(T[index]);
		root.left = generateTreeHelper(T, index * 2);
		root.right = generateTreeHelper(T, index * 2 + 1);
		return root;
	}

}
