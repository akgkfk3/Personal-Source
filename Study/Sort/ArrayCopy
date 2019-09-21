package Array;

public class ArrayCopy {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int[] arr2 = {3,3,3,3,3};
		
		Copy(arr,1,arr2,1,7);
		
		for (int i = 0; i<arr2.length; i++) {
			System.out.print(arr2[i] + "\t");
		}

	}

	public static void Copy(int[] src, int srcPos, int[] dest, int destPos, int length) {
		// src - 전송 배열
		// srcPos - 전송 배열의 복사될 첫 인덱스
		// dest - 수신 배열
		// destPos - 수신 배열 공간 내 게시 위치
		// length - 복사될 배열 공간수
		
		if (srcPos > src.length || destPos > dest.length) {
			System.out.println("전송배열 혹은 수신 배열 인덱스 번호가 잘못되었습니다.");
			return;
		} else if (srcPos + length > src.length+1 || destPos + length > dest.length +1) {
			System.out.println("복사할 길이가 너무 긴 것 같습니다.");
			return;
		}
		for (int i = srcPos; i<srcPos+length; i++) {
			dest[destPos] = src[i];
			destPos++;
		}
		
	}
}
