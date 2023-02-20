package StudentComparison;

import java.util.Scanner;

public class StudentArrayBinSearch { // 이진탐색은 리스트보다 인덱스를 가진 배열이 효율적이므로 리스트를 배열로 바꾸어 구현
	public int searchStudentID(int target, Student[] a) { // ID 이진 탐색
		int f = 0, r = a.length - 1;
		do {
			int c = (f + r) / 2;
			if (a[c].ID == target) {
				a[c].print();
				return c;
			} else if (a[c].ID < target) {
				f = c + 1;
			} else {
				r = c - 1;
			}
		} while (f <= r);
		return -1;
	}
	
	public int searchStudentName(String target, Student[] a) { // name 이진 탐색
		int f = 0, r = a.length - 1;
		do {
			int c = (f + r) / 2;
			if (a[c].name.equals(target)) {
				a[c].print();
				return c;
			} else if (a[c].name.compareTo(target) < 0) {
				f = c + 1;
			} else {
				r = c - 1;
			}
		} while (f <= r);
		return -1;
	}
	
	public int searchStudentPhone(String target, Student[] a) { // phone 이진 탐색
		int f = 0, r = a.length - 1;
		do {
			int c = (f + r) / 2;
			
			if (a[c].phone.equals(target)) {
				a[c].print();
				return c;
			} else if (a[c].phone.compareTo(target) < 0) {
				f = c + 1;
			} else {
				r = c - 1;
			}
		} while (f <= r);
		return -1;
	}
	
	public int searchStudentMail(String target, Student[] a) { // mail 이진 탐색
		int f = 0, r = a.length - 1;
		do {
			int c = (f + r) / 2;
			if (a[c].mail.equals(target)) {
				a[c].print();
				return c;
			} else if (a[c].mail.compareTo(target) < 0) {
				f = c + 1;
			} else {
				r = c - 1;
			}
		} while (f <= r);
		return -1;
	}
	
	public int searchStudentMajor(String target, Student[] a) { // major 이진 탐색
		int f = 0, r = a.length - 1;
		do {
			int c = (f + r) / 2;
			if (a[c].major.equals(target)) {
				a[c].print();
				return c;
			} else if (a[c].major.compareTo(target) < 0) {
				f = c + 1;
			} else {
				r = c - 1;
			}
		} while (f <= r);
		return -1;
	}
}
