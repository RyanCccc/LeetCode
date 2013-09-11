package algorithm;

import program.Testable;

public class PlusOne implements Testable{
	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		boolean needExtra = true;
		for(int i : digits)
			if (i!=9)
				needExtra = false;
		int carry = 1;
		int[] ret;
		if(needExtra){
			ret = new int[digits.length+1];
			for(int i=digits.length-1; i>=0; i--){
				int sum = carry + digits[i];
				if(sum>9){
					sum = 0;
					carry = 1;
				}else{
					carry = 0;
				}
				ret[i+1] = sum;
			}
			ret[0] = carry;
		}else{
			ret = digits;
			for(int i=digits.length-1; i>=0; i--){
				int sum = carry + digits[i];
				if(sum>9){
					sum = 0;
					carry = 1;
				}else{
					carry = 0;
				}
				digits[i] = sum;
			}
		}
        return ret;
    }
	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		int[] ret = plusOne((int[])args[0]);
		int[] exp = (int[])res;
		for(int i=0; i<exp.length; i++){
			if(ret[i]!=exp[i])
				return false;
		}
		return true;
	}

}
