package Array;

public class ArraySwap {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		Swap(arr,1,4);
		
	}
	public static void Swap(int[] arr, int srcPos, int destPos) {
		
		if (srcPos >= arr.length || destPos >= arr.length) {
			System.out.println("인덱스 번호 잘못 입력했어요.");
			return;
		}
		int cnt;
		cnt = arr[destPos];
		arr[destPos] = arr[srcPos];
		arr[srcPos] = cnt;
	}

}