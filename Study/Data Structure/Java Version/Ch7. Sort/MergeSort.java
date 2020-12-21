package Sort;

public class Merge extends BasicCommand{
	
	@SuppressWarnings("rawtypes")
	private static Comparable[] tmp;
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		tmp = new Comparable[a.length];
		divide_conquer_merge(a, 0, a.length-1);
		tmp = null;
	}
	
	@SuppressWarnings("rawtypes")
	private static void divide_conquer_merge(Comparable[] a, int first, int last) {
		
		int mid = (first + last)/2;
		
		if(first < last) {
			divide_conquer_merge(a, first, mid);
			divide_conquer_merge(a, mid+1, last);
			
			int p = first;
			int q = mid+1;
			int idx = p;
			
			while (p <= mid || q <= last) { 
				if (q > last || (p <= mid && greater(a[q], a[p]))) {
					tmp[idx++] = a[p++]; 
				} else { 
					tmp[idx++] = a[q++]; 
				} 
			}
			
			for(int i=first; i<=last; i++) {
				a[i] = tmp[i];
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] ss = {2,7,3,9,1,5,133,152,15,24,4,8};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
