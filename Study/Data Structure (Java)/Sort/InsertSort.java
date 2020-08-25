package Array;

public class InsertSort {
	public static void main(String[] args) {

		int[] arr = { 211, 255, 3, 5, 4, 6, 50, 51, 55, 56, 58, 59, 21, 23, 795, 546, 435, 1, 546 }; // 공간 9개

		Insert(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static void Insert(int[] arr) {
		int tmp = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				tmp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = tmp;

				for (int j = i; j > 0; j--) {
					if (arr[j - 1] > arr[j]) {
						tmp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = tmp;
					}
				}
			}
		}
	}
}
