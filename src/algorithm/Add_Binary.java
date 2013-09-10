package algorithm;

import program.*;

public class Add_Binary implements Testable{
	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length()==0)
        	return b;
        if(b.length()==0)
        	return a;
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1;
        int j =b.length()-1;
        String ca = a.substring(a.length()-1);
        String cb = b.substring(b.length()-1);
		int carry = 0;
		int ia,ib;
		while(ca!="0" || cb!="0"){
			ia = Integer.parseInt(ca);
			ib = Integer.parseInt(cb);
			int sum = ia+ib+carry;
			if(sum>1){
				sum = sum-2;
				carry = 1;
			}else{
				carry =0;
			}
			sb.insert(0, sum);
			i--;
			j--;
			ca = (i<0)?"0":a.substring(i,i+1);
			cb = (j<0)?"0":b.substring(j,j+1);
		}
		if(carry!=0){
			sb.insert(0, carry);
		}
		return sb.toString();
    }

	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		//System.out.println(addBinary((String)a,(String)b));
		return addBinary((String)args[0],(String)args[1]).equals((String)res);
	}
}
