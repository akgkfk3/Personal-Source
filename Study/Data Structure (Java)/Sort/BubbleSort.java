package Array;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 211, 255, 3, 5, 4, 6, 50, 51, 55, 56, 58, 59, 21, 23, 795, 546, 435, 1, 546 }; // 공간 9개

		Bubble(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}


	public static void Bubble(int[] arr) {
		int tmp = 0;

		for (int i = arr.length - 1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}

			}

		}
	}
}
