package StudentComparison;

import java.util.NoSuchElementException;

import org.w3c.dom.Node;

public class SList <E extends Comparable<E>> {
	protected SNode head;
	private int size;
	public SList() {
		head = null;
		size = 0;
	}

	public int search(E target) {
		SNode p = head;
		for(int k = 0; k < size; k++) {
			if(target == p.getItem()) {return k;}
			p = p.getNext();
		}
		return -1;
	}

	public void insertFront(E newItem) {
		head = new SNode(newItem, head);
		size++;
	}

	public void insertAfter(E newItem, SNode p) {
		p.setNext(new SNode(newItem, p.getNext()));
		size++;
	}

	public void deleteFront() {
		if(size == 0) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}

	public void deleteAfter(SNode<E> p) {
		if (p == null) throw new NoSuchElementException();
		SNode t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	
	public SNode<E> getHead() { 
		return head; 
		}
	
//	public SNode<E> getTail() {
//		SNode<E> p;
//		for (p = head; p != null; p = p.getNext()) {
//			if (p.getNext() == null); {
//				break;
//			}
//		}
//		return p;
//	}
//	
//	public SNode<E> getMid() {
//		SNode<E> f;
//		SNode<E> s = head;
//		for (f = head; f != null; f = f.getNext()) {
//			f = f.getNext();
//			s = s.getNext();
//			if (f == null) {
//				break;
//			}
//		}
//		return s;
//	}
	
	public int size() { 
		return size; 
		}
	 
	public boolean isEmpty() { 
		return size == 0; 
		}	
	
	public void print(){
		for (SNode<E> p = head; p != null; p = p.getNext()) 
			System.out.print(p.getItem()+"\t");
	}
	
	public void clear() { // 리스트를 비움
		for (SNode<E> p = head; p != null; p = p.getNext()) {
			deleteAfter(p);
		}
		head = null;
		size = 0;
		
	}
	
	public Object[] SListToArray() { // 리스트를 배열로 변환
		Object[] tempArray = new Object[size]; // 리스트 저장용 임시 배열 생성
		int i = 0;
		for (SNode<E> p = head; p != null; p = p.getNext()) { // head부터 시작, 다음 노드가 null이 아닐 때까지
			tempArray[i++] = (E) p.getItem(); // 배열에 노드의 item 저장
		}
		return tempArray;
	}
	
	public void ArrayToSList(Object[] temp) { // 배열을 리스트로 변환
		int s = size; // 원래 리스트의 크기
		clear(); // 리스트를 비움
		for (int i = s; i > 0; i--) { // 배열의 뒤부터
			insertFront((E) temp[i-1]); // 리스트의 앞에 삽입
		}
	}
}
