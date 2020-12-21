import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	
	/*
	 * 그래프 탐색 - 너비 우선 탐색 (Breadth First Search)
	 */
	
	private class Edge {
		int adjvertex;									// 간선의 다른쪽 정점
		
		@SuppressWarnings("unused")
		public Edge(int v) {
			adjvertex = v;
		}
	}
	
	private int N;										// 그래프 정점의 수
	private List<Edge>[] graph;									
	private boolean[] visited;							// BFS 수행중 방문한 정점을 True로 만듬
	
	public BFS(List<Edge>[] adjList) {
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		for(int i=0; i<N; i++) visited[i] = false;		// 배열 초기화
		for(int i=0; i<N; i++) if(!visited[i]) bfs(i);
	}
	
	public void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();	// 큐 선언
		visited[i] = true;
		q.add(i);										// 큐에 시작 정점 삽입
		while(!q.isEmpty()) {
			int j = q.remove();							// 큐에서 정점 j를 가져옴
			System.out.print(j + " ");
			for(Edge e : graph[j]) {					// 정점 j에 인접한 정점들 중 방문안된 정점 하나씩 방문
				if(!visited[e.adjvertex]) {
					visited[e.adjvertex] = true;
					q.add(e.adjvertex);					// 새로이 방문된 정점을 큐에 삽입
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print("테스트 공간");
	}
}
