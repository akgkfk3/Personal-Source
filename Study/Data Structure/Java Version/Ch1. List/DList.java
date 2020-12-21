import java.util.NoSuchElementException;

/**
 * @author sHu
 * @category List
 */

public class DList<E> {
	
	/*
	 * 이중 연결리스트 (Doubly Linked List)
	 */
	
	// 연결 리스트의 첫 노드, 마지막 노드를 가리키는 레퍼런스 변수들
	// 이 두 노드들은 실제로 항목을 저장하기 위한 것이 아니다.
	// 실제 항목을 저장하지 않는 노드를 Dummy 노드라고 부른다.
	protected DNode<E> head, tail;
	
	// 연결 리스트의 항목 수
	protected int size;
	
	public DList() {
		head = new DNode<E>(null,null,null);
		tail = new DNode<E>(null,head,null);
		head.setNext(tail);
		size = 0;
	}
	
	// 삽입 연산 (insertBefore, insertAfter)
	public void insertBefore(DNode<E> p, E newItem) {	// p가 가리키는 노드 앞에 삽입
		DNode<E> t = p.getPrevious();
		DNode<E> newNode = new DNode<E>(newItem, t, p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}
	
	public void insertAfter(DNode<E> p, E newItem) {	// p가 가리키는 노드 뒤에 삽입
		DNode<E> t = p.getNext();
		DNode<E> newNode = new DNode<E>(newItem, p, t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}
	
	// 삭제 연산 (delete)
	public void delete(DNode<E> x) { 					// x가 가리키는 노드 삭제
		if(x == null) {
			throw new NoSuchElementException();
		}
		DNode<E> f = x.getPrevious();
		DNode<E> r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}

class DNode <E> {
	
	// Data to save
	private E item;
	
	// Before Reference
	private DNode<E> previous;
	
	// Next Reference
	private DNode<E> next;
	
	public DNode(E newItem, DNode<E> p, DNode<E> q) {
		item = newItem;
		previous = p;
		next = q;
	}
	
	// getter, setter Method
	public E getItem() {return item;}
	public DNode<E> getPrevious() {return previous;}
	public DNode<E> getNext() {return next;}
	public void setItem(E newItem) {item = newItem;}
	public void setPrevious(DNode<E> p) {previous = p;}
	public void setNext(DNode<E> q) {next = q;}
}