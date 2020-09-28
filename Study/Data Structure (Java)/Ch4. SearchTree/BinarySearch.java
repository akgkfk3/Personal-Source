
public class BinarySearch {

	/*
	 * 이진탐색 (배열)
	 */

	public static void main(String[] args) {

		int[] test = { 1, 4, 6, 8, 10, 15, 17, 19 };

		int ss = searchArray(test, 0, 7, 15);
		System.out.println(ss);

	}

	public static int searchArray(int[] array, int first, int last, int x) {

		if (first > last) return -1;

		int mid = (first + last) / 2;

		if (array[mid] == x) {return mid;} 
		else if (array[mid] < x) {return searchArray(array, mid + 1, last, x);} 
		else {return searchArray(array, first, mid - 1, x);}
	}
}
