package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                int get = map.get(target-numbers[i]);
                ret[0] = Math.min(i+1,get);
                ret[1] = Math.max(i+1,get);
            }
            map.put(numbers[i], i+1);
        }
        return ret;
    }
	public static void main(String[] args){
		int[] ret = new TwoSum().twoSum(new int[]{2,7,11,19},9);
		System.out.println(ret[0]);
		System.out.println(ret[1]);
	}
}
