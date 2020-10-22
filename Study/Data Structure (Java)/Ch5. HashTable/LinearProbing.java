public class LinearProbing<K,V> {
	
	/*
	 * 개방주소 방식(Open Addressing) - 선형조사 (Linear Probing) 
	 */
	
	// 테이블 크기
	private int M = 13;
	
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
				return;
			}
			
			if(a[i].equals(key)) {						// 이미 key 존재
				d[i] = data;							// 데이터만 갱신
				return;
			}
			i = (initialpos + j++) % M;					// i = 다음 위치
		} while(i != initialpos);						// 현재 i가 초기위치와 같게되면 루프 종료 -> empty 원소가 없는 것이기에 삽입에 실패했고, 재해싱 작업을 거쳐야 한다.

	}
	
	public V get(K key) {								// 탐색 연산
		
		int initialpos = hash(key);						
		int i = initialpos, j = 1;
		
		while(a[i] != null) {							// a[i]가 empty가 아니면
			if(a[i].equals(key)) {
				return d[i];							// 탐색 성공
			}
			i = (initialpos + j++) % M; 				// i = 다음 위치
		}
		return null;									// 탐색 실패
	}
	
	// 삭제 연산은 추후에 구현하도록 한다.
	// 삭제 연산에서는 삭제할 원소에 특별한 값(실제 키들과 구별되는 값)을 저장해야 한다.
	// 삭제된 원소를 null로 초기화시키면 이후에 수행되는 탐색에 문제가 발생하는데, 탐색은 empty 원소가 나타나면 실패로 간주하기 때문이다.
	// 또한, 특별한 값은 실제 키가 아니므로 추후 삽입할 때에 이 곳에 새로운 키를 저장할 수 있어야 한다.

	public static void main(String[] args) {
		LinearProbing<String, String> test = new LinearProbing<String, String>();
		test.put("ㅎㅎ", "테스트");
		System.out.println("테스트 공간");
	}
}
