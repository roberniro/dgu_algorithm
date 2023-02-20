package StudentComparison;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static void result(int a) { // 탐색 결과 출력 메소드
		if (a == -1) {
			System.out.println("찾는 값이 없습니다.");
		} else {
			System.out.printf(">> %d번째에 있습니다. \n", a+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in, "EUC-KR"); // EUC-KR로 입력 받음
		CSVReader r = new CSVReader(); // CSVReader 객체 생성
		SList<Student> sList = r.csvReader(); // Student 객체 단일연결리스트에 csv의 값 저장
		StudentListSeqSearch s = new StudentListSeqSearch(); // 선형탐색클래스 객체 생성
		StudentArrayBinSearch b =new StudentArrayBinSearch(); // 이진탐색클래스 객체 생성
		
		Object[] temp = sList.SListToArray(); // 리스트를 객체 배열로 변환
		Student[] sArray = new Student[temp.length]; // 객체 배열의 크기만큼의 Student 배열 생성
		for (int i = 0; i < temp.length; i++) { // 객체 배열의 원소를 Student 배열에 저장
			sArray[i] = (Student) temp[i];
		}
		
		System.out.println("<주소록 탐색>");
		
		int sortType = -1; // 정렬 방법의 값을 -1로 초기화
		while (sortType != 0) {
			int searchType = -1, targetI = -1; // 탐색 방법, 목표 정수형의 값을 -1로 초기화
			String targetS = null; // 목표 문자열의 값을 null로 초기화
			System.out.println();
			System.out.println("정렬 방법을 입력하세요.");
			System.out.print("1. ID / 2. Name / 3. Phone / 4. Mail / 5. Major / 0. 종료 >> ");
			sortType = scn.nextInt();
			
			switch(sortType) { // 정렬 방법에 따라 배열 정렬하고 리스트에 다시 저장
			case 1:
				Arrays.sort(sArray);
				sList.ArrayToSList(sArray);
				break;
			case 2:
				Arrays.sort(sArray, Student.WITH_NAME);
				sList.ArrayToSList(sArray);
				break;
			case 3:
				Arrays.sort(sArray, Student.WITH_PHONE);
				sList.ArrayToSList(sArray);
				break;
			case 4:
				Arrays.sort(sArray, Student.WITH_MAIL);
				sList.ArrayToSList(sArray);
				break;
			case 5:
				Arrays.sort(sArray, Student.WITH_MAJOR);
				sList.ArrayToSList(sArray);
				break;
			case 0:
				System.out.println("종료합니다."); // 0이 입력되면 종료
				searchType = 0; // 다음 반복문 실행 X
				break;
			}
			
			while (searchType != 0) {
				int dataType = -1; // 탐색 자료형을 -1로 초기화
				System.out.println();
				System.out.println("탐색 방법을 입력하세요.");
				System.out.print("1. 선형 / 2. 이진 / 0. 이전으로 >> ");
				searchType = scn.nextInt();
				switch (searchType) {
				case 1:
					while (dataType != 0) { 
						SNode head = sList.getHead();
						int size = sList.size();
						System.out.println();
						System.out.println("탐색할 자료형을 입력하세요.");
						System.out.print("1. ID / 2. Name / 3. Phone / 4. Mail / 5. Major / 0. 이전으로 >> ");
						dataType = scn.nextInt();
						if (dataType != 0) {
							System.out.println();
							System.out.print("탐색할 값을 입력하세요. >> ");
							if (dataType == 1) { // 탐색 자료형이 1이면 정수를 입력
								targetI = scn.nextInt();
							} else { // 탐색 자료형이 1이 아니면 문자열을 입력
								targetS = scn.next();
							}
						}
						switch(dataType) { // 자료형에 따른 선형탐색 후 출력
						case 1:
							result(s.searchStudentID(targetI, head, size));
							break;
						case 2:
							result(s.searchStudentName(targetS, head, size));
							break;
						case 3:
							result(s.searchStudentPhone(targetS, head, size));
							break;
						case 4:
							result(s.searchStudentMail(targetS, head, size));
							break;
						case 5:
							result(s.searchStudentMajor(targetS, head, size));
							break;
						case 0: 
							break;
						}
					}
				case 2:
					int dataTypeS = -1; // 정렬 타입을 저장하기 위한 dataTypeS를 -1로 초기화
					while (dataType != 0) {
						System.out.println();
						System.out.println("동작을 선택하세요.");
						System.out.print("1. 입력 / 0. 이전으로 >> ");
						dataTypeS = dataType = scn.nextInt();
						if (dataType == 1) { 
							dataTypeS = sortType; // 이진탐색은 정렬된 데이터만 사용하므로 정렬 타입과 같은 타입만 입력
							System.out.println();
							System.out.print("탐색할 값을 입력하세요. >> ");
							if (dataTypeS == 1) { // 탐색 자료형이 1이면 정수를 입력
								targetI = scn.nextInt();
							} else { // 탐색 자료형이 1이 아니면 문자열을 입력
								targetS = scn.next();
							}	
						}
						switch(dataTypeS) { // 자료형에 따른 이진 탐색 후 출력
						case 1:
							result(b.searchStudentID(targetI, sArray));
							break;
						case 2:
							result(b.searchStudentName(targetS, sArray));
							break;
						case 3:
							result(b.searchStudentPhone(targetS, sArray));
							break;
						case 4:
							result(b.searchStudentMail(targetS, sArray));
							break;
						case 5:
							result(b.searchStudentMajor(targetS, sArray));
							break;
						case 0:
							break;
						}
					}
				case 0:
					break;
				}
			}
			
		}		
	}
}
