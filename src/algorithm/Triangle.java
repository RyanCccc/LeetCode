package algorithm;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int size = triangle.size();
        int[] sums = new int[size];
        for(int row=0; row<size;row++){
            ArrayList<Integer> cur = triangle.get(row);
            if(row!=0)
            	sums[size-1-row]= cur.get(0)+sums[size-row];
            for(int i=1; i<cur.size()-1; i++){
                sums[size-1-row+i] = sums[size-1-row+i]>sums[size-row+i]?(sums[size-row+i]+cur.get(i)):(sums[size-1-row+i]+cur.get(i));
            }
            sums[size-1] = sums[size-1] + cur.get(cur.size()-1);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<sums.length;i++){
            min=min<sums[i]?min:sums[i];
        }
        return min;
    }
	
	public void test(ArrayList<ArrayList<Integer>> triangle){
		
		System.out.println(minimumTotal(triangle));
	}
}
