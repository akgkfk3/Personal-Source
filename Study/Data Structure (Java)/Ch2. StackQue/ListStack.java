package StackQue;

import java.util.EmptyStackException;

public class ListStack<E> {
	
	// 스택 top 항목을 가진 Node를 가리키는 레퍼런스 변수
	private Node<E> top;
	
	// 스택의 항목 수
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	
	// 스택에 있는 항목의 수를 리턴
	public int size() {return size;}
	
	// 스택이 empty이면 true 리턴
	public boolean isEmpty() {return size == 0;}
	
	// 탐색 연산 (peek)
	public E peek() {									// 스택 top 항목만을 리턴
		if(isEmpty()) {
			throw new EmptyStackException();			// underflow 경우에 프로그램 정지
		}
		return top.getItem();
	}
	
	// 삽입 연산 (push)
	public void push(E newItem) {						
		Node<E> newNode = new Node<E>(newItem, top);	// 리스트 앞 부분에 삽입 
		top = newNode;									// top이 새 노드를 가리킴
		size++;											// 스택 항목 수 1 증가
	}
	
	// 삭제 연산 (pop)
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();			// underflow 경우에 프로그램 정지	
		}
		E topItem = top.getItem();						// 스택 top 항목을 topItem에 저장
		top = top.getNext();							// top이 top 바로 아래 항목을 가리킴
		size--;											// 스택 항목수 1 감소
		return topItem;
	}
	
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