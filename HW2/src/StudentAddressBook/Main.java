package StudentAddressBook;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in, "EUC-KR");
		CSVReader<String, Student> cr = new CSVReader("C:\\Users\\denir\\Documents\\dgu_algorithm01\\workspace\\Homework2\\src\\샘플주소록.csv"); 
		AVLtree<String, Student> at = cr.StudentCSVReader();
		
		System.out.println("<주소록 이진트리 탐색>");
		System.out.println("학생 목록 전위순회 출력");
		at.print(at.getRoot());
		System.out.println();
		System.out.println();
		System.out.println("찾을 정보를 입력하세요");
		int menu = -1;
		String name = null;
		while (menu != 0) {
			System.out.println();
			System.out.print("1. 학번, 2. 전화번호, 3. 이메일, 4. 전공, 0. 종료 >> ");
			menu = sc.nextInt();
			if (menu != 0) {
				do {
					System.out.print("찾을 학생의 이름을 입력하세요 >> ");
					name = sc.next();
					if (at.get(name) == null) {
						System.out.println(name + "은 주소록에 없습니다. 다시입력하세요.");
					}
				} while (at.get(name) == null);
			}
			switch(menu) {
			case 1:
				int ID = at.get(name).getID();
				System.out.println(name + "의 학번은 " + ID + "입니다.");
				break;
			case 2:
				String PN = at.get(name).getPhone();
				System.out.println(name + "의 전화번호는 " + PN + "입니다.");
				break;
			case 3:
				String EM = at.get(name).getMail();
				System.out.println(name + "의 이메일주소는 " + EM + "입니다.");
				break;	
			case 4:
				String MJ = at.get(name).getMajor();
				System.out.println(name + "의 전공은 " + MJ + "입니다.");
				break;
			case 0:
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}
}