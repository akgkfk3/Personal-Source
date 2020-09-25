package Array;

public class SelectSort {
	public static void main(String[] args) {

		int[] arr = { 211, 255, 3, 5, 4, 6, 50, 51, 55, 56, 58, 59, 21, 23, 795, 546, 435, 1, 546 }; // 공간 9개

		Select(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}

	public static void Select(int[] arr) {
		int tmp = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}

		}

	}

}
