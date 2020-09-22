package StackQue;

import java.util.NoSuchElementException;

public class ListQueue<E> {
	
	// 큐의 앞과 뒤를 가리키는 레퍼런스 변수
	private QNode<E> front, rear;
	
	// 큐의 항목 수
	private int size;
	
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	
	// 스택에 있는 항목의 수를 리턴
	public int size() {return size;}
		
	// 스택이 empty이면 true 리턴
	public boolean isEmpty() {return size == 0;}
	
	// 삽입 연산 (add)
	public void add(E newItem) {
		QNode<E> newNode = new QNode<E>(newItem, null);				// 새 노드 생성
		if(isEmpty()) front = newNode;								// 큐가 Empty이었으면 front도 newNode를 가리키게 한다.
		else rear.setNext(newNode);									// 그렇지 않으면 rear의 next를 newNode를 가리키게 한다.
		rear = newNode;												// 마지막으로 rear가 newNode를 가리키게 한다.
		size++;														// 큐 항목 수 1 증가
	}
	
	// 삭제 연산 (remove)
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();			// underflow 경우에 프로그램 정지
		E frontItem = front.getItem();								// front가 가리키는 노드의 항목을 frontItem에 저장
		front = front.getNext();									// front가 front 다음 노드를 가리키게 한다.
		size--;														// 큐 항목 수 1감소
		if(isEmpty()) rear = null;									// 큐가 empty이면 rear = null
		return frontItem;
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}	
}

class QNode <E> {
	
	// Data to save
	private E item;
	
	// Next Reference
	private QNode<E> next;
	
	public QNode(E newItem, QNode<E> node) {
		item = newItem;
		next = node;
	}
	
	// getter, setter Method
	public E getItem() {return item;}
	public QNode<E> getNext() {return next;}
	public void setItem(E newItem) {item = newItem;}
	public void setNext(QNode<E> newNext) {next = newNext;}
}