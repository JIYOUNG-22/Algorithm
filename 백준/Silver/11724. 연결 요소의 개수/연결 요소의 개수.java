import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static int count = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());   // 정점의 개수 n
		int m = Integer.parseInt(st.nextToken());   // 간선의 개수 m
		
		visited = new boolean[n+1];   // 방문 확인 배열
		arr = new ArrayList[n+1];   // graph
		for(int i = 1; i < n+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i = 1; i < n+1; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	static void dfs(int index) {
		if(visited[index]) return;
		else {
			visited[index] = true;
			for(int a : arr[index]) {
				dfs(a);
			}
		}
	}
}