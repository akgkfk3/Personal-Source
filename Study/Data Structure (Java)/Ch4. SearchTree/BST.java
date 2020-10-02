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
		
		// 뒤의 setLeft(),setRight()와 같은 맥락으로 삽입 및 삭제시 노드의 연결을 바꾸는 부분으로
		// 기존 노드의 연결을 바꾸거나 재연결하게 된다.
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
	
	// 최솟값 찾기
	public Key min() {
		if(root == null) return null;
		return (Key) min(root).getKey();
	}
	
	public Node<Key,Value> min(Node<Key,Value> n) {
		if(n.getLeft() == null) return n;
		return min(n.getLeft());
	}
	
	// 최솟값 삭제 연산
	public void deleteMin() {
		if(root == null) {
			System.out.println("empty Tree");
			return;
		}
		root = deleteMin(root);
	}
	
	public Node<Key,Value> deleteMin(Node<Key,Value> n) {
		
		// 왼쪽 자식이 null일 경우, 오른쪽 자식을 리턴하여 밑의 setLeft Method를 통해
		// 연결을 바꾸게 되고 분리된 최솟값 노드는 참조되는 레퍼런스가 사라져 GC에 의해 제거
		if(n.getLeft() == null) return n.getRight();
		
		// 왼쪽자식으로 재귀호출
		n.setLeft(deleteMin(n.getLeft()));
		
		// 기존 노드를 재연결
		return n;
	}
	
	// 삭제 연산
	public void delete(Key k) {
		
		// 트리가 비어있는 경우
 		if(root == null) {
			System.out.println("Empty Tree");
			return;
		}
		root = delete(root,k);
	}
	
	public Node<Key,Value> delete(Node<Key,Value> n, Key k) {
		
		// 삭제할 Key값이 없는 경우, null리턴 -> 이후 전 스택 메소드로 null을 갖고 돌아감.
		if(n == null) return null;
		
		int t = n.getKey().compareTo(k);
		
		// 왼쪽 서브트리 탐색
		if(t > 0) n.setLeft(delete(n.getLeft(), k));
		
		// 오른쪽 서브트리 탐색
		else if (t < 0) n.setRight(delete(n.getRight(), k));
		
		// 삭제할 노드 발견
		else {
			// 삭제할 노드 중 자식이 없는 경우 + 자식이 1명 있는 경우
			if(n.getRight() == null) return n.getLeft();
			
			// 삭제할 노드 중 자식이 1명 있는 경우
			if(n.getLeft() == null) return n.getRight();
			
			// 삭제할 노드 중 자식이 2명 있는 경우 (가장 복잡)
			Node<Key,Value> target = n;
			n = min(target.getRight());							// 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 한다.
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft()); 
		}
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
