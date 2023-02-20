package StudentComparison;

public class StudentListSeqSearch { // Student 객체 리스트의 선형탐색
	public int searchStudentID(int target, SNode<Student> h, int n) {
		SNode<Student> p = h;
		for(int k = 0; k < n; k++) {
			if(target == p.getItem().ID) {p.getItem().print(); return k;} // 찾으면 객체의 데이터를 출력하고 순서를 출력
			p = p.getNext();
		}
		return -1;
	}
	
	public int searchStudentName(String target, SNode<Student> h, int n) {
		SNode<Student> p = h;
		for(int k = 0; k < n; k++) {
			if(target.equals(p.getItem().name)) {p.getItem().print(); return k;}
			p = p.getNext();
		}
		return -1;
	}
	
	public int searchStudentPhone(String target, SNode<Student> h, int n) {
		SNode<Student> p = h;
		for(int k = 0; k < n; k++) {
			if(target.equals(p.getItem().phone)) {p.getItem().print(); return k;}
			p = p.getNext();
		}
		return -1;
	}
	
	public int searchStudentMail(String target, SNode<Student> h, int n) {
		SNode<Student> p = h;
		for(int k = 0; k < n; k++) {
			if(target.equals(p.getItem().mail)) {p.getItem().print(); return k;}
			p = p.getNext();
		}
		return -1;
	}
	
	public int searchStudentMajor(String target, SNode h, int n) {
		SNode<Student> p = h;
		for(int k = 0; k < n; k++) {
			if(target.equals(p.getItem().major)) {p.getItem().print(); return k;}
			p = p.getNext();
		}
		return -1;
	}
}
