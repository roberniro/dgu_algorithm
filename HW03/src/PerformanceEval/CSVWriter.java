package PerformanceEval;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
	public static void createCSV(String location, String data) throws IOException {
		// 파일 위치와 데이터를 입력받음
		File csv = new File(location); // 파일 위치 바탕으로 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
		// 파일 형식과 이어쓰기 여부 
		bw.write(data); // 데이터를 쓰고
		bw.newLine(); // 줄바꿈
		bw.flush();
		bw.close();
	}
}
