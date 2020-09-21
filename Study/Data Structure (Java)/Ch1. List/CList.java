package List;

import java.util.NoSuchElementException;

public class CList<E> {
	
	/*
	 * 원형 연결리스트 (Circular Linked List)
	 */
	
	// 연결 리스트의 마지막 노드를 가리키는 레퍼런스 변수
	private CNode<E> last;
	
	// 연결 리스트의 항목 수 
	private int size;
	
	public CList() {
		last = null;
		size = 0;
	}
	
	// 삽입 연산 (insert)
	public void insert(E newItem) {				// last가 가리키는 노드의 다음에 새 노드 삽입
		
		// 새 노드 생성
		CNode<E> newNode = new CNode<E>(newItem,null); 
				
		// 리스트가 비었을 때
		if(last == null) {
			newNode.setNext(newNode);
			last = newNode;
		} 
		
		// 리스트가 비어있지 않을 때
		else {
			newNode.setNext(last.getNext());	// newNode의 다음 노드가 last가 가리키는 노드의 다음 노드가 되도록
			last.setNext(newNode);				// last가 가리키는 노드의 다음 노드가 newNode가 되도록
		}
		size++;
	}
	
	// 삭제 연산 (delete)
	public CNode<E> delete() {					// last가 가리키는 노드의 다음 노드를 제거
		
		if(isEmpty()) throw new NoSuchElementException();
		
		CNode<E> x = last.getNext();			// x가 리스트의 첫 노드를 가리킴.
		
		
		if(x == last) last = null;				// 리스트에 1개의 노드만 있는 경우
		else {
			last.setNext(x.getNext());			// last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록
			x.setNext(null);					// x의 next를 null로 만든다.
		}
		size--;
		return x;
	}
	
	public boolean isEmpty() {return size == 0;}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}

class CNode <E> {
	
	// Data
	private E item;
	
	// Next Reference
	private CNode<E> next;
	
	public CNode(E newItem, CNode<E> node) {
		item = newItem;
		next = node;
	}
	
	// getter, setter Method
	public E getItem() {return item;}
	public CNode<E> getNext() {return next;}
	public void setItem(E newItem) {item = newItem;}
	public void setNext(CNode<E> newNext) {next = newNext;}
}