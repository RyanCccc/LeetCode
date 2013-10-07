package algorithm;

import java.util.*;

public class NQueens {
	
	public ArrayList<String[]> solveNQueens_2(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		boolean[][] set = new boolean[n][n];
		String[] strs = new String[n];
		generateNQueens(n, 0, set, ret, strs);
		return ret;
	}
	
	public void generateNQueens(int n, int row, boolean[][] set, ArrayList<String[]> ret, String[] strs){
		if(row==(n)){
			ret.add(strs.clone());
			return;
		}
		for(int i=0; i<n; i++){
			if(!set[row][i]){
				System.out.println("CURRENT");
				for(boolean[] brow:set){
					System.out.println(Arrays.toString(brow));
				}
				mark(set,row,i,n,true);
				System.out.println("Mark:" + row + " , " + i);
				
				StringBuilder sb = new StringBuilder();
				for(int t=0; t<n; t++){
					sb.append(".");
				}
				sb.replace(i, i+1, "Q");
				strs[row] = sb.toString();
				generateNQueens(n,row+1,set,ret,strs);
				sb.replace(i, i+1, ".");
				strs[row] = sb.toString();
				System.out.println("Unmark:" + row + " , " + i);
				
				mark(set,row,i,n,false);
			}
		}
	}
	public void mark(boolean[][] set, int row, int cell, int n, boolean val){
		set[row][cell]=val;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(Math.abs(row-i)==Math.abs(cell-j)){
					set[i][j] = val;
				}else if(i==row || j==cell){
					set[i][j] = val;
				}
			}
		}
	}
    
    public void test(){
    	ArrayList<String[]> ret = solveNQueens_2(4);
    	for(String[] str : ret){
    		System.out.println(Arrays.toString(str));
    	}
    }
    
}
