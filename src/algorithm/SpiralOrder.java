package algorithm;

import java.util.ArrayList;

public class SpiralOrder {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(matrix, 0, 0, ret);
        return ret;
    }
    public void dfs(int[][] matrix, int row, int cell, ArrayList<Integer> ret){
        ret.add(matrix[row][cell]);
        matrix[row][cell] = Integer.MAX_VALUE;
        if(cell<(matrix[0].length-1) && matrix[row][cell+1]!=Integer.MAX_VALUE){
            dfs(matrix, row, cell+1, ret);
        }else if(row<(matrix.length-1) && matrix[row+1][cell]!=Integer.MAX_VALUE){
            dfs(matrix, row+1, cell, ret);
        }else if(cell>0 && matrix[row][cell-1]!=Integer.MAX_VALUE){
            dfs(matrix, row, cell-1, ret);
        }else if(row>0 && matrix[row-1][cell]!=Integer.MAX_VALUE){
            dfs(matrix, row-1, cell, ret);
        }else{
            return;
        }
    }
}
