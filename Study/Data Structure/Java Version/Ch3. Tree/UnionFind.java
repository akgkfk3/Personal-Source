/**
 * @author sHu
 */

public class UnionFind {
	
	/*
	 * 상호배타적 집합을 위한 트리 연산 (Disjoint Set)
	 */

	protected GNode[] a;
	
	public UnionFind(GNode[] iarray) {
		a= iarray;
	}
	
	// 경로압축
	// i가 속한 집합의 루트를 재귀적으로 찾고 경로상의 각 원소의 부모를 루트로 만든다.
	protected int find(int i) {
		if(i != a[i].getParent()) {
			a[i].setParent(find(a[i].getParent()));
		}
		return a[i].getParent();
	}
	
	// union 연산
	public void union(int i, int j) {
		int iroot = find(i);
		int jroot = find(j);
		
		// 루트노드가 동일하면 더 이상의 수행없이 그대로 리턴
		if(iroot == jroot) return;
		
		// rank가 높은 루트노드가 승자가 된다.
		if(a[iroot].getRank() > a[jroot].getRank()) {			// iroot가 승자
			a[jroot].setParent(iroot);			
		} else if(a[iroot].getRank() < a[jroot].getRank()) {	// jroot가 승자
			a[iroot].setParent(jroot);
		} else {
			a[iroot].setParent(jroot);							// 둘 중에 하나 임의로 승자
			a[jroot].setRank(a[jroot].getRank() + 1);			// rank 1 증가
		}
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}

class GNode {
	int parent;
	int rank;
	
	public GNode(int newParent, int newRank) {
		parent = newParent;
		rank = newRank;
	}
	public int getParent() {return parent;}
	public int getRank() {return rank;}
	public void setParent(int newParent) {parent = newParent;}
	public void setRank(int newRank) {rank = newRank;}
}
