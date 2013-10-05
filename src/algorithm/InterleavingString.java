package algorithm;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        while(!(s1.length()==0 &&s2.length()==0)){
            int l1= findLongest(s1, s3);
            int l2 = findLongest(s2, s3);
            if(l1==0&&l2==0)
                return false;
            if(l1>=l2){
                s1=s1.substring(l1);
                s3=s3.substring(l1);
            }else{
                s2=s2.substring(l2);
                s3=s3.substring(l2);
            }
        }
        return s3.length()==0;
    }
    
    public int findLongest(String s, String q){
        if(s.length()==0||q.length()==0)
            return 0;
        int i=0;
        for(;i<s.length() && i<q.length() && s.charAt(i)==q.charAt(i);i++);
        return i;
    }
    
    public void test(){
    	System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    	System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    	System.out.println(isInterleave("cad", "cac", "caccad"));
    	System.out.println(isInterleave("cac", "cad", "caccad"));
    }
}
