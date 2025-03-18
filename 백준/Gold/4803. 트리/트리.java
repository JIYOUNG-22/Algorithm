import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int tree = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 정점의 개수
            int m = Integer.parseInt(st.nextToken());   // 간선의 개수
            if(n == 0 && m == 0) break;

            graph = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            visited = new boolean[n+1];
            tree = 0;

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    tree += findTree(i);
                }
            }

            if(tree > 1) {
                sb.append("Case ").append(cnt).append(": A forest of ").append(tree).append(" trees.\n");
            } else if(tree == 1) {
                sb.append("Case ").append(cnt).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(cnt).append(": No trees.\n");
            }

            cnt++;
        }

        System.out.println(sb.toString().trim());
    }

    static int findTree(int root) {
        Queue<Integer> q = new LinkedList<>();
        int node = 0;
        int edge = 0;

        q.add(root);

        while(!q.isEmpty()) {
            int now = q.poll();

            if(visited[now]) continue;
            visited[now] = true;
            node++;

            for(int next : graph[now]) {
                edge++;
                if(!visited[next]) q.add(next);
            }
        }

        return (edge / 2) + 1 == node ? 1 : 0;
    }
}
