/**
 * @author S.s
 * @category Sort
 */

public class Selection extends BasicCommand{
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				if(greater(a[min], a[j])) min = j;
			}
			swap(a,i,min);
		}
	}
	
	public static void main(String[] args) {
		Integer[] ss = {300,6,3,9,1000,2,6,4,3,100,233};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
