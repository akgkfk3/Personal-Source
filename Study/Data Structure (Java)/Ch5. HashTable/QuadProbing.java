/**
 * @author sHu
 * @category HashTable
 */

public class QuadProbing<K,V> {
	
	/*
	 * 개방주소 방식(Open Addressing) - 이차조사 (Quadratic Probing) 
	 */
	
	// 항목 수 및 테이블 크기
	private int N = 0, M = 13;
	
	// 해시 테이블
	@SuppressWarnings("unchecked")
	private K[] a = (K[]) new Object[M];
	
	// key관련 데이터 저장
	@SuppressWarnings("unchecked")
	private V[] d = (V[]) new Object[M];
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;		// 제산법
	}
	
	private void put(K key, V data) {					// 삽입 연산
		
		int initialpos = hash(key);						// 초기 위치
		int i = initialpos, j = 1;
		
		do {
			if(a[i] == null) {							// 삽입 위치 발견
				a[i] = key;								// key를 해시 테이블에 저장
				d[i] = data;							// key관련 데이터를 동일한 인덱스 하에 저장
				N++;									// 항목 수 1증가
				return;
			}
			
			if(a[i].equals(key)) {						// 이미 key 존재
				d[i] = data;							// 데이터만 갱신
				return;
			}
			i = (initialpos + j * j++) % M;				// i = 다음 위치
		} while(N < M);						
		
	}
	
	public V get(K key) {								// 탐색 연산
		
		int initialpos = hash(key);						
		int i = initialpos, j = 1;
		
		while(a[i] != null) {							// a[i]가 empty가 아니면
			if(a[i].equals(key)) {
				return d[i];							// 탐색 성공
			}
			i = (initialpos + j * j++) % M; 			// i = 다음 위치
		}
		return null;									// 탐색 실패
	}
	
	public static void main(String[] args) {
		QuadProbing<String, String> test = new QuadProbing<String, String>();
		test.put("테스트", "공간");
		System.out.println("테스트 공간");
	}
}
