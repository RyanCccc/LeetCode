package program;

import java.util.ArrayList;
import java.util.Arrays;
import util.Tree;
import util.TreeNode;
import algorithm.Add_Binary;
import algorithm.Combinations;
import algorithm.Max_Depth;
import algorithm.Min_Depth;
import algorithm.Path_Sum;

public class Program {
	public final static int NULL = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] A = new int[] { 5, 4, 8, 11, NULL, 13, 4, 7, 2, NULL, NULL, NULL,
				NULL, NULL, 1 };
		int[] C = new int[] { 5, 4, 8, 11, NULL, 13, 4, 7, 2, NULL, NULL, NULL,
				NULL, NULL, 1, 2 };
		TreeNode nodeA = Tree.generateTree(A);
		int[] B = new int[] { 5 };
		TreeNode nodeB = Tree.generateTree(B);
		TreeNode nodeC = Tree.generateTree(C);
		// Tree.printTree(node);

		System.out.println("=======Test Path_Sum========");
		Path_Sum path_sum = new Path_Sum();
		result(path_sum, new Object[]{nodeA}, 22);
		result(path_sum, new Object[]{nodeB}, 5);

		System.out.println("=======Test Min_Sum========");
		Min_Depth min_depth = new Min_Depth();
		result(min_depth, new Object[]{nodeA}, 3);

		System.out.println("=======Test Max_Sum========");
		Max_Depth max_depth = new Max_Depth();
		result(max_depth, new Object[]{nodeA}, 4);
		result(max_depth, new Object[]{nodeB}, 1);
		result(max_depth, new Object[]{nodeC}, 5);

		System.out.println("=======Test Add_Binary========");
		Add_Binary add_binary = new Add_Binary();
		result(add_binary, new Object[]{"11", "1"}, "100");
		result(add_binary, new Object[]{"11", ""}, "11");
		result(add_binary, new Object[]{"1111111", "1"}, "10000000");

		System.out.println("=======Test toNestedList========");
		Integer[][] arrays = new Integer[][] { { 2, 4 }, { 3, 4 } };
		System.out.println(toNestedList(arrays));

		System.out.println("=======Test Combinations========");
		Combinations combinations = new Combinations();
		result(combinations, new Object[]{3,2}, toNestedList(new Integer[][]{{1,2},{1,3},{2,3}}));
		Integer[][] input = new Integer[][] { { 2, 4 }, { 3, 4 }, { 2, 3 },
				{ 1, 2 }, { 1, 3 }, { 1, 4 } };
		ArrayList<ArrayList<Integer>> res = toNestedList(input);
		result(combinations, new Object[]{4, 2}, res);
	}

	public static ArrayList<ArrayList<Integer>> toNestedList(Integer[][] t) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		for (Integer[] i : t) {
			ret.add(new ArrayList<Integer>(Arrays.asList(i)));
		}
		return ret;
	}

	public static void result(Testable test, Object[] args, Object res) {
		boolean result = test.test(args, res);
		if (result)
			System.out.println("pass");
		else
			System.out.println("failed");
	}
}
