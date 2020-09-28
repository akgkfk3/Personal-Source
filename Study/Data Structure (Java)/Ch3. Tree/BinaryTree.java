package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
	
	/*
	 * 이진트리 (Binary Tree)
	 */

	private Node<Key> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public Node<Key> getRoot() {return root;}
	
	public void setRoot(Node<Key> newRoot) {root = newRoot;}
	
	public boolean isEmpty() {return root == null;}
	
	// 전위 순회 (Preorder Traversal)
	public void preorder(Node<Key> n) {
		if(n != null) {
			System.out.println(n.getKey() + "방문\t");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	// 중위 순회 (Inorder Traversal)
	public void inorder(Node<Key> n) {
		if(n != null) {
			inorder(n.getLeft());
			System.out.println(n.getKey() + "방문\t");
			inorder(n.getRight());
		}
	}
	
	// 후위 순회 (Postorder Traversal)
	public void postorder(Node<Key> n) {
		if(n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.println(n.getKey() + "방문\t");
		}
	}
	
	// 레벨 순회 (Levelorder Traversal)
	public void levelorder(Node<Key> root) {
		
		// 큐 자료구조 이용
		Queue<Node<Key>> q = new LinkedList<Node<Key>>();
		
		Node<Key> t;
		
		// 루트노드 큐에 삽입
		q.add(root);
		
		while(!q.isEmpty()) {
			
			t = q.remove();										// 큐에서 가장 앞에 있는 노드 제거
			System.out.println(t.getKey() + "방문");			// 제거된 노드 출력(방문)
			
			if(t.getLeft() != null) {							// 제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());								// 큐에 왼쪽 자식 삽입
			}
			
			if(t.getRight() != null) {							// 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());							// 큐에 오른쪽 자식 삽입
			}
		}
		
	}	
	
	// 트리의 노드 수 검사 (size) - 후위순회
	public int size(Node<Key> n) {								// n을 루트노드로 하는 (서브)트리에 있는 노드 수
		if(n == null)	return 0;
		else return size(n.getLeft()) + size(n.getRight()) + 1;
	}
	
	// 트리의 높이 계산 (height) - 후위순회
	public int height(Node<Key> n) {							// n을 루트노드로 하는 (서브)트리의 높이
		if(n == null) return 0;									// null이면 0리턴
		else return (1 + Math.max(size(n.getLeft()), size(n.getRight())));
	}
	
	// 2개의 이진트리에 대한 동일성 검사 (isEqual) - 전위순회
	public boolean isEqual(Node<Key> n, Node<Key> m) {
		
		// 둘 중에 하나라도 null일 때 둘 다 null이면 true, 아니면 false
		if(n == null || m == null) return (n == m);
		
		// 둘 다 null이 아니면 item 비교
		if(n.getKey().compareTo(m.getKey()) != 0) return false;
		
		// item이 같으면 왼쪽/오른쪽 자식으로 재귀호출
		return (isEqual(n.getLeft(),m.getLeft()) && isEqual(n.getRight(),m.getRight()));
	}
	
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
		// 이진트리에 데이터 삽입 삭제 갱신하는 연산들은 이진탐색트리에서 소개할 것이다
	}

}

class Node<Key extends Comparable<Key>> {
	
	private Key item;
	private Node<Key> left;
	private Node<Key> right;
	
	public Node(Key newItem, Node<Key> lt, Node<Key> rt) {
		item = newItem; lt = null; rt = null;
	}
	
	public Key getKey() {return item;}
	public Node<Key> getLeft() {return left;}
	public Node<Key> getRight() {return right;}
	public void setKey(Key newItem) {item = newItem;}
	public void setLeft(Node<Key> lt) {left = lt;}
	public void setRight(Node<Key> rt) {right = rt;}
}
