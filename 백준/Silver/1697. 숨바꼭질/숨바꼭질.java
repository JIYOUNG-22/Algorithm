import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dist = new int[100001];
    static int depth = 0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        k = Integer.parseInt(st.nextToken());   // 동생의 위치

        bfs(n);

        System.out.println(depth);
    }

    static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);
        visited[now] = true;

        while(!q.isEmpty()) {
            int nowNode = q.poll();
            if(nowNode - 1 >= 0 && nowNode - 1 <= 100000 && !visited[nowNode - 1]) {
                visited[nowNode - 1] = true;
                q.offer(nowNode - 1);
                dist[nowNode - 1] = dist[nowNode] + 1;
            }
            if(nowNode + 1 >= 0 && nowNode + 1 <= 100000 && !visited[nowNode + 1]) {
                visited[nowNode + 1] = true;
                q.offer(nowNode + 1);
                dist[nowNode + 1] = dist[nowNode] + 1;
            }
            if(nowNode * 2 >= 0 && nowNode * 2 <= 100000 && !visited[nowNode * 2]) {
                visited[nowNode * 2] = true;
                q.offer(nowNode * 2);
                dist[nowNode * 2] = dist[nowNode] + 1;
            }

            if(nowNode - 1 == k) {
                depth = dist[nowNode - 1];
                return;
            } else if(nowNode + 1 == k) {
                depth = dist[nowNode + 1];
                return;
            } else if(nowNode * 2 == k) {
                depth = dist[nowNode * 2];
                return;
            }
        }
    }

}
