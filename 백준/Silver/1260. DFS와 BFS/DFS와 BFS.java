import java.io.*;
import java.util.*;

public class Main {

		static ArrayList<Integer>[] graph;
    static int n;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 정점의 개수 n
        int m = Integer.parseInt(st.nextToken());   // 간선의 개수 m
        int start = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점 번호

        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n+1];
        sb = new StringBuilder();
        dfs(start);
        System.out.println(sb.toString().trim());

        visited = new boolean[n+1];
        sb = new StringBuilder();
        bfs(start);
        System.out.println(sb.toString().trim());
    }

    static void dfs(int now) {   // 깊이 우선 탐색
        if(visited[now]) return;

        visited[now] = true;
        sb.append(now).append(" ");

        for(int next : graph[now]) {
            dfs(next);
        }
    }

    static void bfs(int start) {   // 너비 우선 탐색
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for(int next : graph[now]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}