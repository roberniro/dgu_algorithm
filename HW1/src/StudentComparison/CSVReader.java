package StudentComparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	public SList<Student> csvReader() throws IOException {
		SList<Student> l = new SList<Student>(); 
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\denir\\Documents\\dgu_algorithm01\\workspace\\Homework\\src\\샘플주소록.csv"));
		int count = 0;
		
		while(true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			if (count != 0) { // 데이터의 첫줄(데이터 분류)을 제외
				String[] temp = line.split(","); // 쉼표로 분리하여 배열에 저장
				Student s = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]); // 배열의 원소로 Student 객체를 생성
				l.insertFront(s); // 리스트의 앞에 삽입
			}
			count++;
		}
		return l;
	}
}
