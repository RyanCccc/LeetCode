package algorithm;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int low=0;
        int high=matrix.length-1;
        if(target>matrix[high][0]){
            low=high;
        }
        if(target<matrix[low][0]){
            return false;
        }
        while((high-low)>0){
            int mid = (low+high)/2;
            if(target>matrix[mid][0]){
                low=mid+1;
            }else if(target<matrix[mid][0]){
                high=mid-1;
            }else{
                low=mid;
                break;
            }
        }
        int row = low;
        low=0;
        high = matrix[row].length-1;
        while(!(low>high)){
            int mid = (low+high)/2;
            if(target>matrix[row][mid]){
                low=mid+1;
            }else if(target<matrix[row][mid]){
                high=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
	
	public void test(){
		int[][] matrix = new int[][]{{1}};
		System.out.println(searchMatrix(matrix, 2));
	}
}
