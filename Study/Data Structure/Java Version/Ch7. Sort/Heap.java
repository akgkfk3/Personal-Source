package Sort;

public class Heap extends BasicCommand {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		
		// a[0]은 사용 안함
		int heapSize = a.length - 1;
		
		// 힙 만들기
		for(int i = heapSize/2; i > 0; i--)
			downheap(a, i, heapSize);
		
		// 힙 정렬
		while(heapSize > 1) {
			swap(a,1,heapSize--);								// a[1]과 힙의 마지막 항목과 교환
			downheap(a, 1, heapSize);							// 위배된 힙속성 고치기
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static void downheap(Comparable[] a, int p, int heapSize) {
		while(2*p <= heapSize) {								// s = 왼쪽 자식의 인덱스
			int s = 2*p;
			if (s < heapSize && !greater(a[s], a[s+1])) s++;	// 오른쪽 자식이 큰 경우
			if(greater(a[p], a[s])) break;						// 힙 속성 만족하는 경우
			swap(a,p,s);										// 힙 속성 만족 안하면 부모(p)와 자식 승자(s) 교환
			p = s;												
		}
	}
	
	public static void main(String[] args) {
		Integer[] ss = {300,6,3,9,1000,2,6,4,3,100,233};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
