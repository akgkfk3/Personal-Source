package SearchTree;

public class BST<Key extends Comparable<Key>, Value> {
	
	/*
	 * 이진 탐색트리 (Binary Search Tree)
	 */
	
	public Node<Key, Value> root;
	
	public BST(Key newId, Value newName) {
		root = new Node<Key,Value>(newId, newName);
	}
	
	public Node<Key, Value> getRoot() {
		return root;
	}
	
	// 탐색 연산
	public Value get(Key k) {
		return get(root,k);
	}
	
	public Value get(Node<Key, Value> n, Key k) {
		
		// k를 발견하지 못한 경우
		if(n == null) return null;
		
		int t = n.getKey().compareTo(k);
		
		// 왼쪽 서브트리 탐색 (k < 노드 n의 id) 
		if(t > 0) return get(n.getLeft(),k);
		
		// 오른쪽 서브트리 탐색 (k > 노드 n의 id) 
		else if(t < 0) return get(n.getRight(),k); 
		
		// k를 가진 노드 발견
		else return (Value) n.getValue();
	}
	
	// 삽입 연산
	public void put(Key k, Value v) {
		root = put(root,k,v);
	}
	
	public Node<Key, Value> put(Node<Key,Value> n, Key k, Value v) {
		
		// 노드를 삽입하는 부분
		if(n == null) return new Node<Key,Value>(k,v);
		
		int t = n.getKey().compareTo(k);
		
		// 왼쪽 서브트리에 삽입
		if(t > 0) n.setLeft(put(n.getLeft(),k,v));
		
		// 오른쪽 서브트리에 삽입
		else if (t < 0) n.setRight(put(n.getRight(), k, v));
		
		// 노드 n의 name을 v로 갱신
		else n.setValue(v);
		
		// 기존 노드를 재연결
		return n;
	}
	
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}

}

class Node <Key extends Comparable<Key>, Value> {
	private Key id;
	private Value name;
	private Node<Key, Value> left, right;
	
	public Node(Key newId, Value newName) {
		id = newId;
		name = newName;
		left = right = null;
	}

	public Key getKey() {
		return id;
	}

	public void setKey(Key newId) {
		id = newId;
	}

	public Value getValue() {
		return name;
	}

	public void setValue(Value newName) {
		name = newName;
	}

	public Node<Key, Value> getLeft() {
		return left;
	}

	public void setLeft(Node<Key, Value> newLeft) {
		left = newLeft;
	}

	public Node<Key, Value> getRight() {
		return right;
	}

	public void setRight(Node<Key, Value> newRight) {
		right = newRight;
	}
	
}
