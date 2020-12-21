public class Quick extends BasicCommand{
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		quick(a, 0, a.length -1);
	}
	
	@SuppressWarnings("rawtypes")
	public static void quick(Comparable[] a, int first, int last) {
		
		if(first < last) {
			
			int pibot = first, end = last, tmp;
			
			while(pibot != end) {
				if(pibot < end) {
					if(greater(a[pibot], a[end])) {
						swap(a,pibot++,end);
						tmp = pibot; pibot = end; end = tmp;
					} else {
						end--;
					}
				} else {
					if(greater(a[pibot], a[end])) {
						end++;
					} else {
						swap(a,pibot--,end);
						tmp = pibot; pibot = end; end = tmp;
					}
				}
			}
			quick(a,first,pibot-1);
			quick(a,pibot+1, last);
		}
	}
	
	public static void main(String[] args) {
		Integer[] ss = {295,212,157,2,5,1,962,465,4,8,7,222,6,5024,12,15,3,500,400,1024};
		printList(ss);
		sort(ss);
		printList(ss);
	}
}
