package SearchTree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	// root Node
	private Node root;
	
	// Node class (Inner class)
	private class Node {
		Key id;
		Value name;
		Node left, right;
		boolean color;		// Parent Node Link Color
		
		// Node Constructor
		public Node(Key k, Value v, boolean col) {
			id = k;
			name = v;
			color = col;
			left = right = null;
		}
		
		// 노드의 오른쪽 레드 link를 왼쪽으로 옮기는 연산
		private Node rotateLeft(Node n) {
			Node x = n.right;
			n.right = x.left;
			x.left = n;
			x.color = n.color;
			n.color = RED;
			return x;
		}
		
		// 노드의 왼쪽 레드 link를 오른쪽으로 옮기는 연산
		private Node rotateRight(Node n) {
			Node x = n.left;
			n.left = x.right;
			x.right = n;
			x.color = n.color;
			n.color = RED;
			return x;
		}
		
		// 노드의 색 변환 연산
		private void flipColors(Node n) {
			
		}
		
		
		
	}
	
	private boolean isEmpty() { return root == null; }
	
	private boolean isRed(Node n) {
		if(n == null) return false;		// null color is Black
		return (n.color == RED);
	}
	
	
	// Search algorithm
	public Value get(Key k) {
		 return get(root, k);
	}
	
	public Value get(Node n, Key k) {
		
		// 탐색 실패
		if(n == null) return null;
		
		int t = n.id.compareTo(k);
		
		// 왼쪽 서브트리 탐색
		if(t<0) return get(n.left, k);
		
		// 오른쪽 서브트리 탐색
		else if(t>0) return get(n.right, k);
		
		// 탐색 성공
		else return (Value) n.name;
	}
	
	// Insert algorithm
	
	// Delete algorithm
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}

}
