import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static ArrayList<Integer>[] graph;   // graph
	static int[] dist;
	static boolean[] visited;
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());   // 전체 사람의 수 n
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());   // 관계의 개수 m
		
		// ArrayList<>[] 초기화
		graph = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// graph 표현
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			graph[parent].add(child);
			graph[child].add(parent);
		}
		
		// a, b 사이의 촌수 구하기 (a를 기준으로 dfs)
		dist = new int[n+1];
		visited = new boolean[n+1];

		System.out.println(bfs(a,b));
	}
	
	static int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		dist[start] = 0;
		visited[start] = true;
		
		queue.offer(start);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : graph[now]) {
				if(!visited[next]) {
					dist[next] = dist[now] + 1;
					if(next == end) return dist[next];
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
		
		return -1;
	}
}