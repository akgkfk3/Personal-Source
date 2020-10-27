/**
 * @author S.s
 * @category Sort
 */

public class Insertion extends BasicCommand{
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		for(int i=1;i < a.length; i++) {
			for(int j=i; j>0; j--) {
				if(greater(a[j-1], a[j])) swap(a,j-1,j);
				else break;
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] ss = {300,6,3,9,1000,2,6,4,3,100,233};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
