package algorithm;

import program.Testable;

public class Word_Search implements Testable {
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(DFS(board,word,i,j)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean DFS(char[][] board, String word, int i, int j) {
		if (word.length() == 0)
			return true;
		if (word.length() == 1){
			return board[i][j] == word.charAt(0);
		}
		if (board[i][j] == word.charAt(0)) {
			char tem = board[i][j];
			board[i][j] = '#';
			boolean ret = false;
			if (i > 0) {
				ret = ret || DFS(board, word.substring(1), i - 1, j);
			}
			if (i < (board.length - 1)) {
				ret = ret || DFS(board, word.substring(1), i + 1, j);
			}
			if (j < (board[0].length - 1)) {
				ret = ret || DFS(board, word.substring(1), i, j + 1);
			}
			if (j > 0) {
				ret = ret || DFS(board, word.substring(1), i, j - 1);
			}
			board[i][j] = tem;
			return ret;
		} else {
			return false;
		}
	}

	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		return exist((char[][]) args[0], (String) args[1]) == (Boolean) res;
	}

}
