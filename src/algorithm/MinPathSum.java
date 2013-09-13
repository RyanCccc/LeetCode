public class MinPathSum{
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] map = new int[grid.length][grid[0].length];
        map[0][0] = grid[0][0];
        for(int i=1; i<grid[0].length; i++){
            map[0][i] = map[0][i-1] + grid[0][i];
        }
        for(int i=1; i<grid.length; i++){
            map[i][0] = map[i-1][0] + grid[i][0];
        }
        for(int row=1; row<grid.length; row++){
            for(int cell=1; cell<grid[0].length; cell++){
                map[row][cell] = min(map[row][cell-1], map[row-1][cell]) + grid[row][cell];
            }
        }
        return map[map.length-1][map[0].length-1];
    }
    
    public int min(int a, int b){
        return a<b?a:b;
    }
}
