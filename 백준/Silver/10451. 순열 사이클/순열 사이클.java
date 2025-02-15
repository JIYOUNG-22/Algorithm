import java.io.*;
import java.util.*;

public class Main {
	
	static int t, n;
	static int[] array;			// 배열
	static boolean[] visited;	//  방문 여부
	static int cycle;			// 사이클 갯수
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());	// 테스트케이스 갯수
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			array = new int[n+1];
			visited = new boolean[n+1];
			cycle = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int k = 1; k <= n; k++) {
				if(visited[k]==false) {
					dfs(k);
					cycle++;
				}
			}		
			
			System.out.println(cycle);
		}
    }
	
	static void dfs(int index) {
		visited[index] = true;
		
		if(visited[array[index]] == false) {
			dfs(array[index]);
		} else return;
	}
}