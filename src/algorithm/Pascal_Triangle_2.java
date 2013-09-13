package algorithm;

import java.util.ArrayList;

import program.*;

public class Pascal_Triangle_2 implements Testable{
	public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
		rowIndex++;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i=0; i<rowIndex; i++){
        	ret.add(1);
        }
        for(int i=1; i<rowIndex-1; i++){
        	for(int j=i; j>=1; j--){
        		int val = ret.get(j-1) + ret.get(j);
        		ret.set(j, val);
        	}
        }
        return ret;
    }
	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ret = getRow((Integer)args[0]);
		System.out.println(ret);
		return true;
	}

}
