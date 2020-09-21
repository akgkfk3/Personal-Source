package StackQueDeque;

import java.util.EmptyStackException;

public class ArrayStack<E> {
	
	// 스택을 위한 배열
	private E s[];

	// 스택의 top 항목의 배열 원소 인덱스
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		s = (E[]) new Object[1]; 					// 초기에 크기가 1인 배열 생성
		top = -1;
	}
	
	// 스택에 있는 항목의 수를 리턴
	public int size() {return top+1;}
	
	// 스택이 empty이면 true 리턴
	public boolean isEmpty() {return top == -1;}	
	
	
	// 동적 배열 (Dynamic Array)
	@SuppressWarnings("unchecked")
	private void resize(int newSize) { 	 			// 배열크기 조절
		Object[] t = new Object[newSize];			// newSize 크기의 새로운 배열 t생성
		for(int i=0; i<s.length; i++) t[i] = s[i]; 	// 배열 복사
		s =(E[]) t;									// 배열 t를 배열 a로
	}
	
	// 탐색 연산 (peek)
	public E peek() {								// 스택 top 항목의 내용만을 리턴
		if(isEmpty()) {
			throw new EmptyStackException();		// underflow 경우에 프로그램 정지
		}
		return s[top];
	}
	
	// 삽입 연산 (push)
	public void push(E newItem) {
		if(size() == s.length) resize(2*s.length);	// 스택을 2배의 크기로 확장
		s[++top] = newItem;							// 새 항목을 push
	}
	
	// 삭제 연산 (pop)
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();		// underflow 경우에 프로그램 정지
		}
		E item = s[top];
		s[top--] = null;							// null로 초기화
		
		if(size() > 0 && size() == s.length/4) {
			resize(s.length/2);						// 스택을 1/2 크기로 축소
		}
		return item;
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}	

}
