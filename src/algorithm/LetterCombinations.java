package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinations {
	public ArrayList<String> letterCombinations(String digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> ret = new ArrayList<String>();
        if(digits.length()==0){
            return ret;
        }
        if(digits.length()==1){
            return getBase(digits);
        }
        ArrayList<String> cur = getBase(digits.substring(0,1));
        ArrayList<String> next = letterCombinations(digits.substring(1));
        for(String s:cur){
            for(String q:next){
                ret.add(s+q);
            }
        }
        return ret;
    }
    
    public ArrayList<String> getBase(String s){
        int digit = Integer.parseInt(s);
        ArrayList<String> list = null;
        switch(digit){
            case 2:
                list = new ArrayList<String>(Arrays.asList(convertArray("abc")));
                break;
            case 3:
                list = new ArrayList<String>(Arrays.asList(convertArray("def")));
                break;
            case 4:
                list = new ArrayList<String>(Arrays.asList(convertArray("ghi")));
                break;
            case 5:
                list = new ArrayList<String>(Arrays.asList(convertArray("jkl")));
                break;
            case 6:
                list = new ArrayList<String>(Arrays.asList(convertArray("mno")));
                break;
            case 7:
                list = new ArrayList<String>(Arrays.asList(convertArray("pqrs")));
                break;
            case 8:
                list = new ArrayList<String>(Arrays.asList(convertArray("tuv")));
                break;
            case 9:
                list = new ArrayList<String>(Arrays.asList(convertArray("wxyz")));
                break;
        }
        return list;
    }

    public String[] convertArray(String str){
        String[] s = str.split("");
        String[] ret = new String[s.length-1];
        for(int i=1; i<s.length;i++){
            ret[i-1] = s[i];
        }
        return ret;
    }
    
    public void test(){
    	System.out.println(letterCombinations("23"));
    }
}
