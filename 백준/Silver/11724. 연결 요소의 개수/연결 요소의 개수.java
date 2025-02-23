import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] graph;	// 그래프 표현
	static boolean[] visited;   // 방문 확인 배열
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());   // 정점의 개수 N
		int M = Integer.parseInt(st.nextToken());   // 간선의 개수 M
		
		// graph 초기화
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		// 방문 배열 초기화
		visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int index) {
		if(visited[index]) return;
		visited[index] = true;
		
		for(int node : graph[index]) {
			if(!visited[node]) dfs(node);
		}
	}
}