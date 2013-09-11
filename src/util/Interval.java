package util;

import java.util.ArrayList;

public class Interval {
	public int start;
	public int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public boolean equals(Object o){
		Interval i = (Interval) o;
		return this.start==i.start && this.end==i.end;
	}
	
	public static ArrayList<Interval> generateInterval(int[] array){
		ArrayList<Interval> list = new ArrayList<Interval>();
		for(int i=0; i<array.length; i+=2){
			list.add(new Interval(array[i],array[i+1]));
		}
		return list;
	}
	
	@Override
	public String toString(){
		return "[" + this.start + "," + this.end + "]";
	}
}