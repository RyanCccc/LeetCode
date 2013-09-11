package algorithm;

import java.util.ArrayList;

import program.Testable;
import util.Interval;

public class Insert_Interval implements Testable {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int start = 0;
		int end = 0;
		for (Interval i : intervals) {
			if (newInterval.start < i.start) {
				break;
			} else if (newInterval.start >= i.start
					&& newInterval.start <= i.end) {
				start++;
				break;
			} else if (newInterval.start > i.end) {
				start += 2;
			}
		}
		for (Interval i : intervals) {
			if (newInterval.end < i.start) {
				break;
			} else if (newInterval.end >= i.start && newInterval.end <= i.end) {
				end++;
				break;
			} else if (newInterval.end > i.end) {
				end += 2;
			}
		}
		ArrayList<Interval> ret = new ArrayList<Interval>();
		for (int i = 0; i < start / 2; i++) {
			ret.add(intervals.get(i));
		}
		if (start % 2 == 1) {
			newInterval.start = intervals.get(start / 2).start;
		}
		if (end % 2 == 1) {
			newInterval.end = intervals.get(end / 2).end;
		}
		ret.add(newInterval);
		for (int i = (end-1)<0?0:(end-1)/ 2 + 1; i < intervals.size(); i++) {
			ret.add(intervals.get(i));
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		return insert((ArrayList<Interval>) args[0], (Interval) args[1])
				.equals((ArrayList<Interval>) res);
	}

}
