package PerformanceEval;

public class IntegerData implements Comparable<IntegerData> {

		int value;
		
		public IntegerData(int value) {
			this.value = value;
		}
		
		public int get( ) {
			return this.value;
		}
		
		public int compareTo(IntegerData o) {
			return this.value - o.value;
		}
}
