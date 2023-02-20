package PerformanceEval;

import java.util.*;

// import org.apache.commons.lang3.RandomStringUtils;

public class Test {

	public static ArrayList<String>  genDataset () {
		
		ArrayList<String> dataset = new ArrayList<String>();
		int STRINGSIZE = 10;
		
		
		// 화면 입력 객체 생성
		Scanner sc = new Scanner(System.in);
				
		System.out.println("생성할 데이터 갯수를 입력 : ");
		int size = sc.nextInt();
		// String DataNum = sc.next();            // 화면에서 문자열 입력
		// int size = Integer.parseInt(DataNum);  // 화면 입력 데이터를 int로 변환
				
		while (dataset.size() < size) {
			
			char[] genChar = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
			for (int i = 0; i < STRINGSIZE; i++) 
				genChar[i] = getAchar();
			String generatedString = new String(genChar);
	 	
			if (!dataset.contains(generatedString)) {
				dataset.add(generatedString);
			}
			// System.out.println(dataset.size());
		}
		
		return dataset;
	}
	
	public static char getAchar() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 
        Random r = new Random();
        char c = alphabet.charAt(r.nextInt(alphabet.length()));
        System.out.println(c);
        return c;
	}
	
	public static void maintest(String[] args) {
		// TODO Auto-generated method stub

		// 1. 데이터 생성
		ArrayList<String> data = genDataset();
		int len = data.size();
		String [] a = (String[]) data.toArray();
		// String [] s = Arrays.toString(a);
		
		// 2. 정렬
		// 2.1 Selection Sort()
		// Selection ss = new Selection();
		Selection.sort(a);
		
		// 2. 시간 측정 데모
		
	}

}
