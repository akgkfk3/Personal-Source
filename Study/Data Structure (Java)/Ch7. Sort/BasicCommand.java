/**
 * @author sHu
 * @category Sort-Command
 */

public class BasicCommand {
	
	@SuppressWarnings("rawtypes")
	protected static void swap(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	/**
	 * @param src [전송 배열]
	 * @param srcPos [전송 배열 공간 내 복사할 시작 위치]
	 * @param dest [수신 배열]
	 * @param destPos [수신 배열 공간 내 복사 시작위치]
	 * @param length [복사할 공간 수]
	 */
	@SuppressWarnings("rawtypes")
	protected static void copy(Comparable[] src, int srcPos, Comparable[] dest, int destPos, int length) {
		for(int i=srcPos, j=destPos; i<src.length; i++,j++)	dest[j] = src[i];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static boolean greater(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}
	
	@SuppressWarnings("rawtypes")
	protected static void printList(Comparable[] a) {
		for(Comparable s : a) System.out.print(s.toString() + ",");
		System.out.println();
	}
}
