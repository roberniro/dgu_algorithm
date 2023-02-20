package StudentAddressBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader<K extends Comparable<K>, I> {
	private String fileName;
	
	CSVReader(String fileName) {
		this.fileName = fileName;
	}
	
	public AVLtree<K, I> StudentCSVReader() throws IOException {
		AVLtree<K, I> at = new AVLtree(); 
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int count = 0;
		
		while(true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			if (count != 0) { // 데이터의 첫줄(데이터 분류)을 제외
				String[] temp = line.split(","); // 쉼표로 분리하여 배열에 저장
				Student s = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]); // 배열의 원소로 Student 객체를 생성
				// bt.add((K) s.getName(),(I) s); // 리스트의 앞에 삽입
				at.addAVL((K) s.getName(), (I) s);
			}
			count++;
		}
		return at;
	}
}
