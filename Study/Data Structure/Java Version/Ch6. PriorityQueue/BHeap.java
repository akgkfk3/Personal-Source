/**
 * @author sHu
 * @category Heap
 */

public class BHeap<Key extends Comparable<Key>, Value> {
	
	/*
	 * 우선순위큐 - 이진힙 
	 * - 최소힙 기준으로 코드작성 하였다.
	 */
	
	private Entry<Key,Value>[] a;											// a[0]은 사용 안함
	
	private int N;															// 힙의 크기 (힙에 있는 항목 수)
	
	public BHeap(Entry<Key,Value>[] harray, int initialSize) {
		a = harray;
		N = initialSize;
	}
	
	public int size() {														// 힙의 크기 리턴
		return N;
	}
	
	private boolean greater(int i, int j) {
		return a[i].getKey().compareTo(a[j].getKey()) > 0;					// 키값 비교
	}
	
	private void swap(int i, int j) {										// a[i]와 a[j] 교환
		Entry<Key,Value> tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	
	private void downheap(int i) {											// i는 현재 노드의 인덱스
		while(2*i < N) {													// i의 왼쪽 자식 노드가 힙에 있으면
			int k = 2*i;													// k는 왼쪽 자식 노드의 인덱스
			
			// k가 마지막 노드일 경우, k+1시 예외가 발생할 수 있으므로 k < N 조건을 추가
			if (k < N && greater(k, k+1)) k++;								// 최소힙 기준이므로 k가 k+1보다 작으면 인덱스 기준을 k+1로 바꾼다 (승자)
			if(!greater(i, k)) break;										// 현재 노드 i가 자식 노드 중 승자(위에서 승자 인덱스 k값)와 같거나 작을시 루프 중단 
			swap(i,k);														// 위의 조건에 false일 시, 현재 노드가 자식 노드보다 크므로 위치 교환
			i = k;															// 자식 승자가 현재 노드가 되어 다시 위의 과정을 반복
		}
	}
	
	private void upheap(int j) {											// j는 현재 노드의 인덱스
		while(j > 1 && greater(j/2, j)) {									// 현재 노드가 루트 노드가 아니면서 부모 노드가 더욱 클 경우
			swap(j/2, j);													// 위치 교환
			j /= 2;															// 부모 노드가 현재 노드가 되어 반복
		}
	}
	
	public void createHeap() {												// 초기 힙 만들기
		// downheap()은 주로 루트노드 삭제연산에서 사용되는데 초기 힙 생성시 힙속성을 만족하기 위해 사용되어 지기도 한다.
		// 초기 힙을 생성하는 createHeap()는 이파리노드에서부터 힙 속성을 만족시키기 위해 downheap()을 루트노드까지 각 노드에 대해 downheap()을
		// 진행하게 되어 시간복잡도가 O(N)에 수렴하게 된다. (트리의 높이와 비례하는 다른 연산과는 다르게)
		for(int i = N/2; i > 0; i--) downheap(i);
	}

	public void insert(Key newKey, Value newValue) {						// 새로운 항목 삽입 -> overflow 검사는 생략
		a[N++] = new Entry<Key, Value>(newKey, newValue);					// 새로운 항목을 배열 마지막 항목 다음에 저장후 항목수 +1
		upheap(N);															// 위로 올라가며 힙속성 회복
	}
	
	public Entry<Key,Value> deleteMin() {									// 최솟값 삭제 (최소힙) -> underflow 검사는 생략
		Entry<Key,Value> min = a[1];										// a[1]의 최솟값을 min으로 저장하여 리턴
		a[1] = a[N--];														// 힙의 마지막 항목과 교환하고 힙크기 -1감소 -> swap(1,N--)로 해도 무방
		a[N+1] = null;														// 마지막 항목을 null 처리
		downheap(1);														// 아래로 내려가며 힙속성 회복
		return min;															// 리턴
	}
	
	// decrease_Key(), delete() 연산은 따로 구현하지 않고 나중에 시간 될 때, 책을 보지 않고 직접 구현하도록 한다.
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}

}

class Entry<Key extends Comparable<Key>, Value> {
	
	private Key ky;
	private Value val;
	
	public Entry(Key ky, Value val) {
		this.ky = ky;
		this.val = val;
	}

	public Key getKey() {
		return ky;
	}

	public void setKey(Key ky) {
		this.ky = ky;
	}

	public Value getVal() {
		return val;
	}

	public void setVal(Value val) {
		this.val = val;
	}
}
