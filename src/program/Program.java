package program;

import algorithm.Add_Binary;
import algorithm.Max_Depth;
import algorithm.Min_Depth;
import algorithm.Path_Sum;
import util.*;

public class Program {
	public final static int NULL = Integer.MIN_VALUE;
	public static void main(String[] args){
		int[] A = new int[]{5,4,8,11,NULL, 13,4,7,2,NULL,NULL,NULL,NULL,NULL,1};
		int[] C = new int[]{5,4,8,11,NULL, 13,4,7,2,NULL,NULL,NULL,NULL,NULL,1,2};
		TreeNode nodeA = Tree.generateTree(A);
		int[] B = new int[]{5};
		TreeNode nodeB = Tree.generateTree(B);
		TreeNode nodeC = Tree.generateTree(C);
		//Tree.printTree(node);
		
		System.out.println("=======Test Path_Sum========");
		Path_Sum path_sum = new Path_Sum();
		result(path_sum, nodeA, 22);
		result(path_sum, nodeB, 5);
		System.out.println("=======Test Min_Sum========");
		Min_Depth min_depth = new Min_Depth();
		result(min_depth, nodeA, 3);
		System.out.println("=======Test Max_Sum========");
		Max_Depth max_depth = new Max_Depth();
		result(max_depth, nodeA, 4);
		result(max_depth, nodeB, 1);
		result(max_depth, nodeC, 5);
		System.out.println("=======Test ADD_BINARY========");
		Add_Binary add_binary = new Add_Binary();
		result(add_binary, "11","1" ,"100");
		result(add_binary, "11","" ,"11");
		result(add_binary, "1111111","1" ,"10000000");
	}
	
	public static void result(Testable test, Object a, Object res){
		boolean result = test.test(a, res);
		if(result)
			System.out.println("pass");
		else
			System.out.println("failed");
	}
	public static void result(Testable test, Object a, Object b, Object c){
		boolean result = test.test(a, b,c);
		if(result)
			System.out.println("pass");
		else
			System.out.println("failed");
	}
}
