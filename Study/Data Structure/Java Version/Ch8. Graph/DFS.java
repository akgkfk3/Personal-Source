import java.util.List;

public class DFS {
	
	/*
	 * 그래프 탐색 - 깊이 우선 탐색 (Depth First Search)
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
	private boolean[] visited;							// DFS 수행중 방문한 정점을 True로 만듬
	
	public DFS(List<Edge>[] adjList) {
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		for(int i=0; i<N; i++) visited[i] = false;		// 배열 초기화
		for(int i=0; i<N; i++) if(!visited[i]) dfs(i);
	}
	
	private void dfs(int i) {
		visited[i] = true;								// 정점 i가 방문되어 visited[i]를 true로
		System.out.println(i+" ");						// 정점 i가 방문되었음을 출력
		for(Edge e : graph[i]) 							// 정점 i에 인접한 각 정점에 대해
			if(!visited[e.adjvertex])					// 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
				dfs(e.adjvertex);
	}

	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}


