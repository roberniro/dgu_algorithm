package StudentAddressBook;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class AVLtree<K extends Comparable<K>, I> {
	private Node<K, I> root;
	
	public Node<K, I> getRoot() { return root; } // root 노드 반환
	public void setRoot(Node<K, I> newRoot) { root = newRoot; } // root 설정
	public boolean isEmpty() { return root == null; } // 빈 트리면 null 반환

	public void delete(K key) {	root = delete(root, key); }  // 삭제 연산
	private Node<K, I> delete(Node<K, I> n, K key) {
		int t = key.compareTo(n.getKey());
		if (t < 0) 		n.setLeft(delete(n.getLeft(), key));
		else if (t > 0) n.setRight(delete(n.getRight(), key));
		else {
			if (n.getLeft() == null)  	  return n.getRight();
			else if (n.getRight() == null) return n.getLeft();
			else {
				Node<K, I> y = n;
				n = min(y.getRight());
				n.setRight(deleteMin(y.getRight()));
				n.setLeft(y.getLeft());
			}
		}
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
		return balance(n);
	}
	
	public void deleteMin() { // 최솟값 삭제 연산
		root = deleteMin(root);
	}
	private Node<K, I> deleteMin(Node<K, I> n) {
		if (n.getLeft() == null) {
			return n.getRight();
		}
		n.setLeft(deleteMin(n.getLeft()));
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
		return balance(n);
	}
	
	public K min() { // 최솟값 찾기
		return min(root).getKey();
	}
	private Node<K, I> min(Node<K, I> n) {
		if (n.getLeft() == null) {
			return n;
		}
		return min(n.getLeft());
	}
	
	public void print(Node<K, I> root) { // 트리 출력
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	
	public void inorder(Node<K, I> n){  // 중위 순회
		if (n != null) {
			inorder(n.getLeft());   // n의 왼쪽 서브 트리를 순회하기 위해
			System.out.print(n.getKey() + " ");  // 노드 n 방문
			inorder(n.getRight());
		}
	}
	
	public void levelorder(Node<K, I> root) { // 레벨 순회
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node<K, I> t;
		q.add(root);  // 루트 노드 큐에 삽입
		while (!q.isEmpty()) { 
			t = q.remove();   //큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey() + " "); // 제거된 노드 출력(방문)
			if (t.getLeft() != null)      // 제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());       // 큐에 왼쪽 자식 삽입
			if (t.getRight() != null)     // 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());      // 큐에  오른쪽 자식 삽입
		} 
	}
	public void preorder(Node<K, I> n) {     // 전위 순회
		if (n != null) {
			System.out.print(n.getKey() + " ");  // 노드 n 방문
			preorder(n.getLeft());  // n의 왼쪽    서브 트리를 순회하기 위해
			preorder(n.getRight()); // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}	
	
	private I get(Node<K, I> n, K key) { // 탐색 연산
		if (n == null) {
			return null;
		}
		int order = n.getKey().compareTo(key);
		if (order > 0) {
			return get(n.getLeft(), key);
		} else if (order < 0) {
			return get(n.getRight(), key);
		} else {
			return n.getItem();
		}
	}
	public I get(K key) {
		return get(root, key);
	}

	private int height(Node<K, I> n) { // 높이 계산 
		if (n == null) {
			return 0;
		}
		return n.getHeight();
	}
	
	private int tallerHeight(int x, int y){  // 높이 비교
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
	
	private Node<K, I> rotateRight(Node<K, I> n) { //우로 회전
		Node<K, I> x = n.getLeft();
		n.setLeft(x.getRight());
		x.setRight(n);
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1); // 높이 갱신
		x.setHeight(tallerHeight(height(x.getLeft()), height(x.getRight())) + 1); // 높이 갱신
		return x; // 회전 후 x가 n의 이전 자리로 이동되었으므로 
	}
	
	private Node<K, I> rotateLeft(Node<K, I> n) { // 좌로 회전
		Node<K, I> x = n.getRight();
		n.setRight(x.getLeft());
		x.setLeft(n); 
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1); // 높이 갱신
		x.setHeight(tallerHeight(height(x.getLeft()), height(x.getRight())) + 1); // 높이 갱신
		return x; // 회전 후 x가 n의 이전 자리로 이동되었으므로 
	}
	
	private Node<K, I> balance(Node<K, I> n) {
		if (bf(n) > 1) {
			if (bf(n.getLeft()) < 0) {
				n.setLeft(rotateLeft(n.getLeft()));
			}
			n = rotateRight(n);
		}
		else if (bf(n) < -1) {
			if (bf(n.getRight()) > 0) {
				n.setRight(rotateRight(n.getRight()));
			}
			n = rotateLeft(n);
		}
		return n;
	}
	
	private int bf(Node<K, I> n) { // bf 계산
		return height(n.getLeft()) - height(n.getRight()); // bf = 왼쪽 서브트리 높이 - 오른쪽 서브트리 높이
	}
	
	public void addAVL(K newKey, I newItem) { // 삽입
		root = addAVL(root, newKey, newItem); 
	}
	private Node<K, I> addAVL(Node<K, I> n, K newKey, I newItem) {
		if (n == null) {
			return new Node(newKey, newItem, 1);
		}
		int order = newKey.compareTo(n.getKey());
		if (order < 0) {
			n.setLeft(addAVL(n.getLeft(), newKey, newItem));
		} else if (order > 0) {
			n.setRight(addAVL(n.getRight(), newKey, newItem));
		} else {
			n.setItem(newItem);
			return n;
		}
		n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
		return balance(n);
	}
}
