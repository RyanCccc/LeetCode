package algorithm;

import java.util.ArrayList;

public class Permutations_2 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(num, 0);
    }
    public ArrayList<ArrayList<Integer>> helper(int[] num, int index){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(index==num.length-1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[index]);
            ret.add(list);
            return ret;
        }
        for(int i=index; i<num.length; i++){
            if(num[index]!=num[i] || i==index){
                swap(num, index, i);
                ArrayList<ArrayList<Integer>> res = helper(num, index+1);
                for(ArrayList<Integer> list:res){
                    list.add(0, num[index]);
                    ret.add(list);
                }
                swap(num, index, i);
            }
        }
        return ret;
    }
    public void swap(int[] num, int i, int j){
    	int tem = num[i];
    	num[i] = num[j];
    	num[j] = tem;
    }
}
