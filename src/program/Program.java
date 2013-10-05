package program;

import java.util.ArrayList;
import java.util.Arrays;
import util.Interval;
import util.ListNode;
import util.Tree;
import util.TreeNode;
import algorithm.Add_Binary;
import algorithm.Combinations;
import algorithm.Insert_Interval;
import algorithm.Max_Depth;
import algorithm.Merge_Intervals;
import algorithm.Min_Depth;
import algorithm.Partition_List;
import algorithm.Pascal_Triangle;
import algorithm.Pascal_Triangle_2;
import algorithm.Path_Sum;
import algorithm.Permutations_2;
import algorithm.PlusOne;
import algorithm.Word_Search;

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
		
		System.out.println("=======Test Word Search========");
		Word_Search word_search = new Word_Search();
		char[][] board = new char[][]{
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		result(word_search, new Object[]{board,"ABCCED"},(Object)true);
		result(word_search, new Object[]{board,"SEE"},(Object)true);
		result(word_search, new Object[]{board,"ABCB"},(Object)false);
		result(word_search, new Object[]{new char[][]{{'A'}},"A"},(Object)true);
		
		System.out.println("=======Test Plus One========");
		PlusOne plusOne = new PlusOne();
		result(plusOne, new Object[]{new int[]{8,9}},(Object)new int[]{9,0});
		result(plusOne, new Object[]{new int[]{9}},(Object)new int[]{1,0});
		result(plusOne, new Object[]{new int[]{9,9,9}},(Object)new int[]{1,0,0,0});
		
		System.out.println("=======Test Insert Interval========");
		Insert_Interval insert_interval = new Insert_Interval();
		ArrayList<Interval> interval_list = Interval.generateInterval(new int[]{1,3,6,9});
		ArrayList<Interval> interval_res = Interval.generateInterval(new int[]{1,5,6,9});
		result(insert_interval, new Object[]{interval_list,new Interval(2,5)}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{1,2,3,5,6,7,8,10,12,16});
		interval_res = Interval.generateInterval(new int[]{1,2,3,10,12,16});
		result(insert_interval, new Object[]{interval_list,new Interval(4,9)}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{1,5});
		interval_res = Interval.generateInterval(new int[]{0,0,1,5});
		result(insert_interval, new Object[]{interval_list,new Interval(0,0)}, (Object)interval_res);
		
		System.out.println("=======Test Merge Intervals========");
		Merge_Intervals merge_intervals = new Merge_Intervals();
		interval_list = Interval.generateInterval(new int[]{1,3,2,6,8,10,15,18});
		interval_res = Interval.generateInterval(new int[]{1,6,8,10,15,18});
		result(merge_intervals, new Object[]{interval_list}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{1,4,1,4});
		interval_res = Interval.generateInterval(new int[]{1,4});
		result(merge_intervals, new Object[]{interval_list}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{1,4,4,5,5,6});
		interval_res = Interval.generateInterval(new int[]{1,6});
		result(merge_intervals, new Object[]{interval_list}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{1,4,0,4});
		interval_res = Interval.generateInterval(new int[]{0,4});
		result(merge_intervals, new Object[]{interval_list}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{2,3,4,5,6,7,8,9,1,10});
		interval_res = Interval.generateInterval(new int[]{1,10});
		result(merge_intervals, new Object[]{interval_list}, (Object)interval_res);
		interval_list = Interval.generateInterval(new int[]{2,2,1,3,3,3,3,4,2,3,4,5,4,4});
		interval_res = Interval.generateInterval(new int[]{1,5});
		result(merge_intervals, new Object[]{interval_list}, (Object)interval_res);
		
		System.out.println("=======Test Pascal_Triangle========");
		Pascal_Triangle pascal_triangle = new Pascal_Triangle();
		result(pascal_triangle, new Object[]{5}, (Object)1);
		Pascal_Triangle_2 pascal_triangle_2 = new Pascal_Triangle_2();
		result(pascal_triangle_2, new Object[]{5}, (Object)1);
		
		System.out.println("=======Test Partition_List========");
		Partition_List partition_list = new Partition_List();
		ListNode head = ListNode.genList(new int[]{1,4,3,2,5,2});
		System.out.println(head);
		result(partition_list, new Object[]{head,3}, (Object)1);
		head = ListNode.genList(new int[]{1});
		result(partition_list, new Object[]{head,2}, (Object)1);
		head = ListNode.genList(new int[]{5,6,7,8});
		result(partition_list, new Object[]{head,1}, (Object)1);
		
		System.out.println("=======Test Permutations_2========");
		Permutations_2 per2 = new Permutations_2();
		System.out.println(per2.permuteUnique(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,2}));
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
