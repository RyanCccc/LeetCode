package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.length()==0)
            return true;
        if(dict.contains(s))
            return true;
        for(int i=1; i<s.length(); i++){
            String str = s.substring(0,i);
            if(dict.contains(str)){
            	String temp = s.substring(i);
            	while(temp.startsWith(str)){
            		temp = temp.substring(i);
            	}
                if(wordBreak(temp, dict))
                    return true;
            }
        }
        return false;
    }
	public ArrayList<String> wordBreak2(String s, Set<String> dict){
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		return helper(s, dict,map);
	}
	public ArrayList<String> helper(String s, Set<String> dict, HashMap<String,ArrayList<String>> map){
		if(map.containsKey(s)){
			return map.get(s);
		}
		ArrayList<String> ret = new ArrayList<String>();
		if(s.length()==0)
            return ret;
		if(dict.contains(s)){
            ret.add(s);
        }
        for(int i=1; i<s.length(); i++){
            String str = s.substring(0,i);
            if(dict.contains(str)){
            	ArrayList<String> list = helper(s.substring(i), dict, map);
                for(String temp : list){
                	ret.add(str+" "+temp);
                }
            }
        }
        map.put(s, ret);
        return ret;
	}
	
	public void test(){
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>(Arrays.asList(new String[]{
				"aaaa","aa","a"
		}));
		System.out.println(wordBreak2(s,dict));
	}
}
