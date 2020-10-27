/**
 * @author S.s
 * @category Sort
 */

public class Bubble extends BasicCommand{
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		for(int i=a.length-1; i>0; i--) 
			for(int j=0; j<i; j++) 
				if(greater(a[j], a[j+1])) swap(a,j,j+1);
	}
	
	public static void main(String[] args) {
		Integer[] ss = {300,6,3,9,1000,2,6,4,3,100,233};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
