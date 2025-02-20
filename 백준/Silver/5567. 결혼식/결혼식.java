import java.io.*;
import java.util.*;
	
public class Main {

		static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int result = 0;
    
    static final int MAX_DIST = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 동기의 수 n
        int m = Integer.parseInt(br.readLine());   // 리스트(관계)의 길이

        visited = new boolean[n+1];
        dist = new int[n+1];

        // graph 초기화
        graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // graph 표현
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

				// 본인 제외
        System.out.println(result - 1);
    }

    public static void dfs(int index) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
	        int currNode = queue.poll();
	        result++;
	        
	        // 친구의 친구일 경우 더 확인할 필요 없음
	        if(dist[currNode] == MAX_DIST) continue;
	        
          for(int nextNode : graph[currNode]) {
              if(!visited[nextNode]) {
                  queue.offer(nextNode);
                  visited[nextNode] = true;
                  dist[nextNode] = dist[currNode] + 1;
              }
           }
        }
    }
}