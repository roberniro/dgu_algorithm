package PerformanceEval;

import java.util.*;

public class GenData {
	
	public static IntegerData[] genIntegerData(int num) {
		IntegerData[] Intdata = new IntegerData[num];
		
		// 객체 배열 초기화 (랜덤 값으로) 
		int i = 0; int val = 0;
		while (i < num) {
			val = (int)(Math.random() * num);
			
			if (IsnotIndata(Intdata, val)) {
				Intdata[i] = new IntegerData(val);
				i++;
			}
		}
		
		return Intdata;
	}
	
	public static boolean IsnotIndata(IntegerData[] data, int val) {
		// ArrayList<Integer> IntList = new ArrayList<>(Arrays.asList(data));
		
		for(IntegerData da : data) {
			if (da == null) return true;
		    if(da.value == val) return false;
		}
		return true;
	}
	
	public static StringData[] genStringData(int num) {
		StringData[] strdata = new StringData[num];
		String[] str = new String[num];
		int STRINGSIZE = 10;
		
		// 객체 배열 초기화 (랜덤 값으로) 
		int i = 0;
        while (i < num) {
			
			char[] genChar = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
			for (int j = 0; j < STRINGSIZE; j++) 
				genChar[j] = getAchar();
			String generatedString = new String(genChar);
	 	
			if (!Arrays.asList(str).contains(generatedString))
				str[i++] = generatedString;
			// System.out.println(dataset.size());
		}
        
        for (i = 0; i < str.length; i++)
        	strdata[i] = new StringData(str[i]);
		
		return strdata;
	}
	
	public static char getAchar() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 
        Random r = new Random();
        char c = alphabet.charAt(r.nextInt(alphabet.length()));
        // System.out.println(c);
        return c;
	}

}
