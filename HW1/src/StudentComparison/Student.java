package StudentComparison;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	public static final Comparator<Student> WITH_NAME = new WithName();
	public static final Comparator<Student> WITH_PHONE = new WithPhone();
	public static final Comparator<Student> WITH_MAIL = new WithMail();
	public static final Comparator<Student> WITH_MAJOR = new WithMajor();
	
	int ID;
	String name, phone, mail, major;
	Student(int ID, String name, String phone, String mail, String major) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.major = major;
	}
	
	public int getID() {return ID;}
	public String getName() {return name;}
	public String getPhone() {return phone;}
	public String getMail() {return mail;}
	public String getMajor() {return major;}
	public void print() { // Student 객체의 데이터를 배열 형태의 문자열로 출력
		System.out.printf("[%d, %s, %s, %s, %s] ", getID(), getName(), getPhone(), getMail(), getMajor());
		}
	
	
	public int compareTo(Student s1) {
		return this.ID-s1.ID;
	}
	
	public static class WithName implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	}
	
	public static class WithPhone implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.phone.compareTo(s2.phone);
		}
	}
	
	public static class WithMail implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.mail.compareTo(s2.mail);
		}
	}
	
	public static class WithMajor implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.major.compareTo(s2.major);
		}
	}
}
