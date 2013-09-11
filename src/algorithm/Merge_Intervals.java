package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import program.Testable;
import util.Interval;

public class Merge_Intervals implements Testable{
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval arg0, Interval arg1) {
				// TODO Auto-generated method stub
				return arg0.start-arg1.start;
			}
		});
		System.out.println(intervals);
		ArrayList<Interval> ret = new ArrayList<Interval>();
		for(int i=0; i<intervals.size(); i++){
			Interval current = intervals.get(i);
			int pivot = current.end;
			if(i>=(intervals.size()-1)){
				//TODO
			}else{
				Interval next = intervals.get(i+1);
				while(pivot>=next.start){
					i++;
					pivot = pivot>next.end?pivot:next.end;
					if(i<(intervals.size()-1))
						next = intervals.get(i+1);
					else
						break;
				}
				current.end = pivot;
			}
			ret.add(current);
		}
		return ret;
    }
	@SuppressWarnings("unchecked")
	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		ArrayList<Interval> list = merge((ArrayList<Interval>)args[0]);
		System.out.println(list);
		return list.equals((ArrayList<Interval>)res);
	}

}
