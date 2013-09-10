package algorithm;

import java.util.*;

import program.Testable;

public class Combinations implements Testable {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {

		return helper(1, n, k);
	}

	public ArrayList<ArrayList<Integer>> helper(int begin, int end, int k) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if ((end - begin + 1) <= k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int tem = begin; tem <= end; tem++) {
				list.add(tem);
			}
			ret.add(list);
			return ret;
		}
		if (k == 0) {
			return ret;
		}
		ret = helper(begin + 1, end, k - 1);
		if (ret.size() == 0) {
			ret.add(new ArrayList<Integer>());
		}
		for (ArrayList<Integer> list : ret) {
			list.add(0, begin);
		}
		ArrayList<ArrayList<Integer>> addition = helper(begin + 1, end, k);
		for (ArrayList<Integer> list : addition) {
			ret.add(list);
		}
		return ret;
	}

	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		// System.out.println(addBinary((String)a,(String)b));
		ArrayList<ArrayList<Integer>> result = combine((Integer) args[0], (Integer) args[1]);
		ArrayList<ArrayList<Integer>> exp = (ArrayList<ArrayList<Integer>>) res;
		for (ArrayList<Integer> r : result) {
			if (!exp.contains(r))
				return false;
		}
		return exp.size() == result.size();
	}
}