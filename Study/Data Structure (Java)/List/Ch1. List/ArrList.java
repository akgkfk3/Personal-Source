package List;

import java.util.NoSuchElementException;

public class ArrList<E> {
	
	/*
	 * "자바와 함께하는 자료구조의 이해" 교재의 소스입니다.
	 * 학습을 위해서 제네릭 배열을 사용한 것으로 보이며, 보통 제네릭은 컴파일 시점에서 타입 체크를 하고, 배열은 런타임 시점에서 요소 타입을 체크해서 예외 발생을 하기에
	 * 서로 요소 타입을 체크하는 시점이 다르기 때문에 타입 안정성의 문제로 배열과 제네릭은 보통 같이 쓰이지 않습니다. (배열은 공변, 제네릭은 불변)
	 * ArrayList의 경우에도 Object[] 배열을 사용해서 구현되어 있습니다.
	 * 
	 * (Example)
	 * ★ 런타임 에러 발생
	 * Object[] objects = new Long[1];
	 * objects[0] = "gogogo"; // ArrayStoreException 예외 발생
	 * 
	 * ★ 컴파일 에러 발생
	 * List<Object> list = new ArrayList<Long>();
	 * list.add("gogogo");
	 */
	
	// 리스트의 항목들을 저장할 배열
	private E a[];
	
	// 리스트의 항목 수
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrList() {
		a = (E[]) new Object[1];
		size = 0;
	}
	
	// 동적 배열 (Dynamic Array)
	@SuppressWarnings("unchecked")
	private void resize(int newSize) { 	 			// 배열크기 조절
		Object[] t = new Object[newSize];			// newSize 크기의 새로운 배열 t생성
		for(int i=0; i<a.length; i++) t[i] = a[i]; 	// 배열 복사
		a =(E[]) t;									// 배열 t를 배열 a로
	}
	
	// 탐색 연산 (peek)
	public E peek(int k) {
		if(isEmpty()) {
			throw new NoSuchElementException();		// underflow 경우에 프로그램 정지
		}
		return a[k];
	}
	
	// 삽입 연산 (insert, insertLast)
	public void insert(E newItem, int k) {			// 새 항목을 k-1번째 항목 다음에 삽입
		if(size == a.length) resize(2*a.length);	// 배열에 빈 공간이 없으면 배열 크기 2배로 확장
		
		for(int i=size-1; i>=k; i--) a[i+1] = a[i]; // 한 칸씩 뒤로 이동
		a[k] = newItem;								// 인덱스 k번째에 항목 삽입
		size++;										// 항목수 1증가
	}
	
	public void insertLast(E newItem) {				// 가장 뒤에 새 항목 삽입
		if(size == a.length) resize(2*a.length);	// 배열에 빈 공간이 없으면 배열 크기 2배로 확장
		a[size++] = newItem;						// 새 항목 삽입
	}
	
	// 삭제 연산 (delete)
	public E delete(int k) {						// k번째 항목 삭제
		if(isEmpty()) {
			throw new NoSuchElementException(); 	// underflow 경우에 프로그램 정지
		}
		E Item = a[k];
		for(int i=k; i<size; i++) a[i] = a[i+1];	// 한 칸씩 앞으로 이동
		size--;
		
		if(size > 0 && size == a.length/4) {		// 배열에 항목들이 1/4만 차지한다면 배열을 1/2 크기로 축소
			resize(a.length/2);
		}
		return Item;
	}
	
	public boolean isEmpty() {	return size == 0;	}
	
	public int count() {	return a.length;	}
	
	public static void main(String[] args) {
		ArrList<String> ss = new ArrList<>();
		ss.insertLast("gg");
		System.out.println(ss.count());
		System.out.println(ss.a.length); 
	}
}


