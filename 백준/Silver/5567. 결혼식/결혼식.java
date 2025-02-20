import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 동기의 수 n
        int m = Integer.parseInt(br.readLine());   // 리스트(관계)의 길이

        visited = new boolean[n+1];
        dis = new int[n+1];

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

        int result = 0;
        for(int i : dis) {
            if(i == 1 || i == 2) result++;
        }

        System.out.println(result);
    }

    public static void dfs(int index) {
        Queue<Integer> queue = new LinkedList<>();

        if(visited[index]) return;
        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            for(int i : graph[queue.peek()]) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    dis[i] = dis[queue.peek()] + 1;
                }
            }
            queue.poll();
        }
    }
}