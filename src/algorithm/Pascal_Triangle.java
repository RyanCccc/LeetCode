package algorithm;

import java.util.ArrayList;

import program.*;

public class Pascal_Triangle implements Testable{
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(numRows == 0 ){
        	return ret;
        }
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		ret.add(list);
		numRows--;
		int level = 1;
		while(numRows!=0){
			list = new ArrayList<Integer>();
			list.add(1);
			for(int i=1; i<level; i++){
				int value = ret.get(level-1).get(i-1) + ret.get(level-1).get(i) ;
				list.add(value);
			}
			list.add(1);
			ret.add(list);
			level++;
			numRows--;
		}
		return ret;
    }
	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret = generate((Integer)args[0]);
		System.out.println(ret);
		return true;
	}

}
