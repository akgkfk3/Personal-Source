/**
 * @author sHu
 * @category HashTable
 */

public class Chaining<K,V> {
	
	/*
	 * 폐쇄주소 방식(Open Addressing) - 체이닝 (Chaining) 
	 */
	
	// 테이블 크기
	private int M = 13;
	
	// 해시 테이블
	private Node[] a = new Node[M];
	
	// Node 클래스
	public static class Node {
		private Object key;
		private Object data;
		private Node next;
		
		public Node(Object newKey, Object newData, Node ref) {
			key = newKey;
			data = newData;
			next = ref;
		}

		public Object getKey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;		// 제산법
	}
	
	
	@SuppressWarnings("unchecked")
	public V get(K key) {								// 탐색 연산
		
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {		// 연결 리스트 탐색
			if(key.equals(x.key)) {
				return (V) x.data;						// 탐색 성공
			}
		}
		return null;
	}
	
	public void put(K key, V data) {
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {
			if(key.equals(x.key)) {						// 이미 key 존재
				x.data = data;							// 데이터만 갱신
			}
		}
		a[i] = new Node(key, data, a[i]);				// 연결 리스트의 첫 노드로 삽입
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}
