import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;

    static int[] visited = new int[1000001];
    static boolean isStair = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());   // 총 층의 수
        s = Integer.parseInt(st.nextToken());   // 강호가 있는 층
        g = Integer.parseInt(st.nextToken());   // 목표 층
        u = Integer.parseInt(st.nextToken());   // 위로
        d = Integer.parseInt(st.nextToken());   // 아래로

        Arrays.fill(visited, -1);
        bfs(s);

        System.out.println(isStair ? "use the stairs" : visited[g]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]++;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now + u <= f && visited[now + u] == -1) {
                q.offer(now + u);
                visited[now + u] = visited[now] + 1;
            }
            if(now - d > 0 && visited[now - d] == -1) {
                q.offer(now - d);
                visited[now - d] = visited[now] + 1;
            }

            if(now + u == g || now - d == g || now == g) {
                return;
            }
        }

        isStair = true;
    }
}
