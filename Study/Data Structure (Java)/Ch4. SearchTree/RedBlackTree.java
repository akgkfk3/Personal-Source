package SearchTree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
	
	/*
	 * 이진 탐색트리 - 레드블랙 트리 (Red-Black Tree)
	 */
	
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
		n.color = !n.color;
		n.left.color = !n.left.color;
		n.right.color = !n.right.color;
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
	public void put (Key k, Value v) {
		root = put(root,k,v);
		root.color = BLACK;
	}
	
	private Node put(Node n, Key k, Value v) {
		
		// 새로운 레드 노드 생성
		if(n == null) return new Node(k,v,RED);
		
		int t = k.compareTo(n.id);
		
		// 왼쪽 서브트리 탐색
		if(t < 0) n.left = put(n.left, k, v);
		
		// 오른쪽 서브트리 탐색
		else if(t > 0) n.right = put(n.right, k, v);
		
		// k가 트리에 존재할 경우, v로 name을 갱신
		else n.name = v;
		
		// 오른쪽 Link가 레드인 경우, 바로 잡는다
		if(!isRed(n.left) && isRed(n.right)) n = rotateLeft(n);
		if(isRed(n.left ) && isRed(n.left.left)) n = rotateRight(n);
		if(isRed(n.left) && isRed(n.right)) flipColors(n);
		
		return n;
	}
	
	// Delete algorithm
	private Node moveRedLeft(Node n) {
		
		// Case 1,2
		flipColors(n);
		
		// Case 2
		if(isRed(n.right.left)) {
			n.right = rotateRight(n.right);
			n = rotateLeft(n);
			flipColors(n);
		}
		return n;
	}
	
	private Node fixUp(Node n) {
		if(isRed(n.right)) n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
		if(isRed(n.left) && isRed(n.right)) flipColors(n);
		return n;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
		root.color = BLACK;
	}
	
	private Node deleteMin(Node n) {
	
		if(n.left == null) return null;
		if(!isRed(n.left) && !isRed(n.left.left))
			n = moveRedLeft(n);
		n.left = deleteMin(n.left);
		return fixUp(n);
	}
	
	// 임의의 k값을 가진 노드를 삭제하는 delete()연산은 미구현
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}

}
