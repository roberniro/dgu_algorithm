package PerformanceEval;

import java.util.Comparator;

public class StringData implements Comparable<StringData> {
	public static final Comparator<StringData> WITH_STRING = new WithString();
	
	String str;
		
	public StringData(String strr) {
		this.str = strr;
	}
	
	public String get( ) {
		return this.str;
	}
	
	public static class WithString implements Comparator<StringData> {
		public int compare(StringData s1, StringData s2) {
			return s1.str.compareTo(s2.str);
		}
	}
	
	public int compareTo(StringData o) {
		// return this.value - o.value;
		return this.str.compareTo(o.str);
	}
}