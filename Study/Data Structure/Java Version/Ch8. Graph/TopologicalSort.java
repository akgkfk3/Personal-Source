import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TopologicalSort {
	
	/*
	 * 그래프 - 위상 정렬 (Topological Sort)
	 */
	
	int N; 													// 그래프의 정점 수
	boolean[] visited;										// DFS 수행 중 방문여부 체크용
	List<Integer>[] adjList;								// 인접 리스트 형태의 입력 그래프
	List<Integer> sequence;									// 위상정렬 순서를 담을 리스트
	
	public TopologicalSort(List<Integer>[] graph) {			// 생성자
		N = graph.length;									
		visited = new boolean[N];							
		adjList = graph;									
		sequence = new ArrayList<>();						
	}

	public List<Integer> tsort() {							// 위상정렬을 위한 DFS 수행
		for(int i=0; i<N; i++) if(!visited[i]) dfs(i);
		Collections.reverse(sequence);						// sequence를 역순으로 만듦
		return sequence;
	}
	
	public void dfs(int i) {								// DFS 수행
		visited[i] = true;
		for(int v : adjList[i]) if(!visited[v]) dfs(v);		// i의 방문이 끝나고 앞으로 방문해야 하는 각 정점 v에 대해					
		sequence.add(i);									// i에서 진출하는 간선이 더 이상 없으므로 i를 sequence에 추가
	}
	
	public static void main(String[] args) {
		System.out.println("테스트 공간");
	}
}
