import java.util.NoSuchElementException;

/**
 * @author sHu
 * @category List
 */

public class SList<E> {
	
	/*
	 * 단순 연결리스트 (Singly Linked List)
	 */
	
	// 연결 리스트의 첫 노드를 가리키는 레퍼런스 변수
	protected Node<E> head;
	
	// 연결 리스트의 항목 수
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}
	
	// 탐색 연산 (search)
	public int search(E target) {					// Target을 검색
		
		Node<E> p = head;
		
		for(int k=0; k<size; k++) {
			if(target == p.getItem()) return k;		// 탐색에 성공한 경우 위치값 k 리턴
			p = p.getNext();
		}
		return -1;									// 탐색을 실패한 경우 -1 리턴
	}
	
	// 삽입 연산 (insertFront, insertAfter)
	public void insertFront(E newItem) {			// 연결리스트 맨 앞에 새 노드 삽입
		head = new Node<E>(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node<E> p) {	// 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node<E>(newItem, p.getNext()));
		size++;
	}

	// 삭제 연산 (deleteFront, deleteAfter)
	public void deleteFront() {						// 리스트의 첫 노드 삭제
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node<E> p) { 			// p가 가리키는 노드의 다음 노드를 삭제
		if(p == null) {
			throw new NoSuchElementException();
		}
		Node<E> t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	
	public boolean isEmpty() {return size == 0;}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}

class Node <E> {
	
	// Data to save
	private E item;
	
	// Next Reference
	private Node<E> next;
	
	public Node(E newItem, Node<E> node) {
		item = newItem;
		next = node;
	}
	
	// getter, setter Method
	public E getItem() {return item;}
	public Node<E> getNext() {return next;}
	public void setItem(E newItem) {item = newItem;}
	public void setNext(Node<E> newNext) {next = newNext;}
}