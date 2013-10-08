package algorithm;

public class RemoveDuplicates {
	public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length==0)
            return 0;
        int prev=A[0]-1;
        int length=0;
        for(int i=0; i<A.length; i++){
            if(prev!=A[i]){
                A[length] = A[i];
                length++;
                prev = A[i];
            }else{
                A[length] = A[i];
                length++;
                while((i+1)<A.length && A[i]==A[i+1]){
                    i++;
                }
            }
        }
        return length;
    }
	public static void main(String[] args){
		int s = new RemoveDuplicates().removeDuplicates(new int[]{1,1,1});
		System.out.println(s);
	}
}
