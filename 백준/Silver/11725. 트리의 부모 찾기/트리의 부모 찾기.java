import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 노드의 개수

        visited = new boolean[n+1];
        parent = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

				StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int now) {
        if(visited[now]) return;

        visited[now] = true;
        for(int next : graph[now]) {
            if(!visited[next]) {
                parent[next] = now;
                dfs(next);
            }
        }
    }
}
