package PerformanceEval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void PrintIntData(IntegerData[] data) {
		for(int i = 0; i < data.length; i++) {
			if (i%10 == 0) System.out.println();
			System.out.printf(data[i].get()+"  ");
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println();
	}
	
	public static void PrintStrData(StringData[] data) {
		for(int i = 0; i < data.length; i++) {
			if (i%10 == 0) System.out.println();
			System.out.printf(data[i].get()+"  ");
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println();
	}
	
	public static String PrintTime(String stype, String dtype, int num, long stime, long ftime) {
		// 반환값 String으로 변경, 인자에 데이터 타입 추가
		long etime = ftime - stime;
		
		System.out.println(stype+": 데이터 "+num+"개 성능측정 결과");
		System.out.println("Start   Time(ns) : "+stime);
		System.out.println("Finish  Time(ns) : "+ftime);
		System.out.println("Elapsed Time(ns) : "+etime);
		System.out.println(stype+", "+stime+", "+ftime+", "+etime); // 데이터 사이즈 추가해서 파일로 출력하게 수정
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		return stype+", "+dtype+", "+num+", "+stime+", "+ftime+", "+etime;
		// csv에 입력할 값 리턴
	}
	
	public static void main(String[] args) throws IOException {
		long startTime, finishTime;
		String sortType;

		// 1. 데이터 생성 
		// 화면에서 생성할 데이터 갯수를 입력 받음
		Scanner sc = new Scanner(System.in);			
		System.out.print("생성할 데이터 갯수를 입력 : ");
		int n = sc.nextInt();
		
		GenData gd = new GenData();
		IntegerData[] intdata = gd.genIntegerData(n);
		IntegerData[] intBestData = intdata; // intBestData에 평균데이터 대입
		Selection.sort(intBestData); // intBestData 오름차순으로 정렬
		int size = intBestData.length;
		IntegerData[] intWorstData = new IntegerData[size];
		for(int i = 0; i < size; i++) { // intBestData 역순으로 하여 intWorstData
			intWorstData[i] = intBestData[size - 1 - i];
		}
		IntegerData[] idata;
		
		StringData[] strdata = gd.genStringData(n);
		StringData[] strBestData = strdata; // strBestData에 평균데이터 대입
		Selection.sort(strBestData); // strBestData 오름차순으로 정렬
		size = intBestData.length;
		StringData[] strWorstData = new StringData[size];
		for(int i = 0; i < size; i++) { // strBestData 역순으로 하여 strWorstData
			strWorstData[i] = strBestData[size - 1 - i];
		}
		StringData[] sdata;
		
		System.out.println("정수형 데이터 - 정렬 이전 : ");
		PrintIntData(intdata);
		
		System.out.println("스트링 데이터 - 정렬 이전 : ");
		PrintStrData(strdata);
		
		// 파일 위치와 저장할 데이터 저장하는 변수 생성
		String CSVLocation = "C:\\Users\\denir\\Documents\\JAVA\\dgu_algorithm01\\workspace\\HW03\\data.csv";
		String CSVData;
		
		Object[] intDataArr = {intBestData, intdata, intWorstData}; // 데이터 저장
		Object[] strDataArr = {strBestData, strdata, strWorstData};
		String[] dataType = {"best", "average", "worst"}; // 데이터 타입 저장
		// Selection Sort
		for (int i = 0; i < 3; i++) {
			System.out.println(dataType[i]); // index통해 데이터 호출
			CSVWriter.createCSV(CSVLocation, dataType[i]); // 데이터 타입 CSV에 입력
			sortType = "Selection Sort";
			idata = (IntegerData[]) intDataArr[i];	// 객체 원소 데이터 배열로 형변환	
			startTime = System.nanoTime();   // 참고: milisecond 단위 시간 측정 - System.currentTimeMillis();
			Selection.sort(idata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (정수형) : ");
			PrintIntData(idata);
			CSVData = PrintTime(sortType, "int", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData); // 데이터 CSV에 입력 
			
			sdata = (StringData[]) strDataArr[i];				// 스트링 대이터 정렬
			startTime = System.nanoTime();   
			Selection.sort(strdata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (스트링) : ");
			PrintStrData(strdata); 
			CSVData = PrintTime(sortType, "String", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
		}
		// Insertion Sort
		for (int i = 0; i < 3; i++) {
			System.out.println(dataType[i]);
			CSVWriter.createCSV(CSVLocation, dataType[i]);
			sortType = "Insertion Sort";
			idata = (IntegerData[]) intDataArr[i];				 // 정수형 대이터 정렬
			startTime = System.nanoTime();   // 참고: milisecond 단위 시간 측정 - System.currentTimeMillis();
			Insertion.sort(idata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (정수형) : ");
			PrintIntData(idata);
			CSVData = PrintTime(sortType, "int", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
			
			sdata = (StringData[]) strDataArr[i];				// 스트링 대이터 정렬
			startTime = System.nanoTime();   
			Insertion.sort(strdata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (스트링) : ");
			PrintStrData(strdata); 
			CSVData = PrintTime(sortType, "String", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
		}
		// Shell Sort
		for (int i = 0; i < 3; i++) {
			System.out.println(dataType[i]);
			CSVWriter.createCSV(CSVLocation, dataType[i]);
			sortType = "Shell Sort";
			idata = (IntegerData[]) intDataArr[i];				 // 정수형 대이터 정렬
			startTime = System.nanoTime();   // 참고: milisecond 단위 시간 측정 - System.currentTimeMillis();
			Shell.sort(idata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (정수형) : ");
			PrintIntData(idata);
			CSVData = PrintTime(sortType, "int", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
			
			sdata = (StringData[]) strDataArr[i];				// 스트링 대이터 정렬
			startTime = System.nanoTime();   
			Shell.sort(strdata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (스트링) : ");
			PrintStrData(strdata); 
			CSVData = PrintTime(sortType, "String", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
		}
		// Heap Sort
		for (int i = 0; i < 3; i++) {
			System.out.println(dataType[i]);
			CSVWriter.createCSV(CSVLocation, dataType[i]);
			sortType = "Heap Sort";
			idata = (IntegerData[]) intDataArr[i];				 // 정수형 대이터 정렬
			startTime = System.nanoTime();   // 참고: milisecond 단위 시간 측정 - System.currentTimeMillis();
			Heap.sort(idata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (정수형) : ");
			PrintIntData(idata);
			CSVData = PrintTime(sortType, "int", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
			
			sdata = (StringData[]) strDataArr[i];				// 스트링 대이터 정렬
			startTime = System.nanoTime();   
			Heap.sort(strdata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (스트링) : ");
			PrintStrData(strdata); 
			CSVData = PrintTime(sortType, "String", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
		}
		// Merge Sort
		for (int i = 0; i < 3; i++) {
			System.out.println(dataType[i]);
			CSVWriter.createCSV(CSVLocation, dataType[i]);
			sortType = "Merge Sort";
			idata = (IntegerData[]) intDataArr[i];				 // 정수형 대이터 정렬
			startTime = System.nanoTime();   // 참고: milisecond 단위 시간 측정 - System.currentTimeMillis();
			Merge.sort(idata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (정수형) : ");
			PrintIntData(idata);
			CSVData = PrintTime(sortType, "int", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
			
			sdata = (StringData[]) strDataArr[i];				// 스트링 대이터 정렬
			startTime = System.nanoTime();   
			Merge.sort(strdata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (스트링) : ");
			PrintStrData(strdata); 
			CSVData = PrintTime(sortType, "String", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
		}
		// Quick Sort
		for (int i = 0; i < 3; i++) {
			System.out.println(dataType[i]);
			CSVWriter.createCSV(CSVLocation, dataType[i]);
			sortType = "Quick Sort";
			idata = (IntegerData[]) intDataArr[i];				 // 정수형 대이터 정렬
			startTime = System.nanoTime();   // 참고: milisecond 단위 시간 측정 - System.currentTimeMillis();
			Quick.sort(idata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (정수형) : ");
			PrintIntData(idata);
			CSVData = PrintTime(sortType, "int", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
			
			sdata = (StringData[]) strDataArr[i];				// 스트링 대이터 정렬
			startTime = System.nanoTime();   
			Quick.sort(strdata);
			finishTime  = System.nanoTime();
			System.out.println(sortType + " 이후 (스트링) : ");
			PrintStrData(strdata); 
			CSVData = PrintTime(sortType, "String", n, startTime, finishTime);
			CSVWriter.createCSV(CSVLocation, CSVData);
		}
	}	
}	
// 다른 정렬 알고리즘도 성능 측정
// 성능측정 결과 파일로 출력 -> 엑셀로 그래프 그리기
// Bucket, LSD, DPQ int a[]로만 가능, 객체 불가능
// Insertion or Selection sort 역방향 정렬 최악의 경우
// N으로 얻은 값에 적절한 상수를 곱하여 데이터를 바탕으로 한 측정치와 맞게 조정 -> 유사성 확인