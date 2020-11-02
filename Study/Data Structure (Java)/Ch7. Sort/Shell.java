package Sort;

public class Shell extends BasicCommand{

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 4;											// 3x+1 간격 : 1, 4, 13, 40, 121,... 중에서 4와 1만 사용
		while(h >= 1) {
			for(int i = h; i < N; i++) 						// h-정렬 수행
				for(int j = i; j >= h && !greater(a[j], a[j-h]); j-=h) 	// 삽입정렬의 조건문 및 Break문을 반복문 조건식에 넣어둔 형태
					swap(a, j, j-h);
			h /= 3;											// 간격을 줄임
		}
	}
	
	public static void main(String[] args) {
		Integer[] ss = {300,6,3,9,1000,2,6,4,3,100,233};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
