package StackQue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	
	// 큐를 위한 배열
	private E[] q;
	
	// 큐의 맨 앞,뒤의 인덱스를 가리키는 변수 및 항목 수
	private int front, rear, size;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		q = (E[]) new Object[2];							// 초기에 크기가 2인 배열 생성
		front = rear = size = 0;
	}
	
	// 스택에 있는 항목의 수를 리턴
	public int size() {return size;}
		
	// 스택이 empty이면 true 리턴
	public boolean isEmpty() {return size == 0;}
	
	// 동적 배열 (Dynamic Array) 
	@SuppressWarnings("unchecked")
	public void resize(int newSize) {						// 큐의 배열크기 조절
		Object[] t = new Object[newSize];					// newSize 크기의 새로운 배열 t 생성
		
		for(int i=1, j=front+1;i < size+1;i++,j++) {		// 배열 q의 항목들을 t[1]으로 복사
			t[i] = q[j%q.length];
		}
		front = 0;
		rear = size;
		q = (E[]) t;										// 배열 t를 배열 q로
	}
	
	// 삽입 연산 (add)
	public void add(E newItem) {
		if((rear+1)%q.length == front) resize(2*q.length);	// 비어있는 원소가 1개 뿐인 경우(즉, 큐가 Full인 경우) 큐의 크기를 2배로 확장
		rear = (rear+1) % q.length;
		q[rear] = newItem;									// 새 항목을 add
		size++;
	}
 	
	// 제거 연산 (remove)
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();	// underflow 경우에 프로그램 정지
		
		front = (front+1)%q.length;
		
		E item = q[front];
		q[front] = null;									// null로 만들어 가지비 컬렉션에 의해 제거되도록
		size --;
		
		if(size > 0 && size == q.length/4) {				// 큐의 항목수가 배열 크기의 1/4가 되면
			resize(q.length/2);								// 큐를 1/2 크기로 축소
		}
		return item;
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}	
}
