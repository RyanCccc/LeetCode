package program;

import algorithm.Min_Depth;
import algorithm.Path_Sum;
import util.*;

public class Program {
	public final static int NULL = Integer.MIN_VALUE;
	public static void main(String[] args){
		int[] A = new int[]{5,4,8,11,NULL, 13,4,7,2,NULL,NULL,NULL,NULL,NULL,1};
		TreeNode nodeA = Tree.generateTree(A);
		int[] B = new int[]{5};
		TreeNode nodeB = Tree.generateTree(B);
		boolean test = false;
		//Tree.printTree(node);
		
		System.out.println("=======Test Path_Sum========");
		Path_Sum path_sum = new Path_Sum();
		result(path_sum, nodeA, 22);
		result(path_sum, nodeB, 5);
		System.out.println("=======Test Min_Sum========");
		Min_Depth min_depth = new Min_Depth();
		result(min_depth, nodeA, 3);
	}
	
	public static void result(Testable test, Object o, int res){
		boolean result = test.test((TreeNode)o, res);
		if(result)
			System.out.println("pass");
		else
			System.out.println("failed");
	}
}
