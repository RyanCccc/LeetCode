package algorithm;

import java.util.LinkedList;
import java.util.List;

public class ValidSudoku {
	public static class Point{
		public int row;
		public int cell;
		public Point(int row, int cell){
			this.row = row;
			this.cell = cell;
		}
	}
	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
		LinkedList<Integer[]>[] table = new LinkedList[9];
		for(int i=0; i<9; i++){
			table[i] = new LinkedList<Integer[]>();
		}
        for(int row=0; row<board.length; row++){
            for(int cell=0; cell<board[0].length; cell++){
                if(board[row][cell]!='.'){
                    int me = board[row][cell]-'0';
                    table[me-1].add(new Integer[]{row, cell});
                }
            }
        }
        for(int i=1; i<=9; i++){
        	LinkedList<Integer[]> list = table[i-1];
        	for(int p=0;p<list.size();p++){
        		for(int q=p+1; q<list.size(); q++){
        			Integer[] p1 = list.get(p);
        			Integer[] p2 = list.get(q);
        			if(p1[0]==p2[0])
        				return false;
        			if(p1[1]==p2[1])
        				return false;
        			if((p1[0]/3==p2[0]/3)&&(p1[1]/3==p2[1]/3))
        				return false;
        		}
        	}
        }
        return true;
    }
}
