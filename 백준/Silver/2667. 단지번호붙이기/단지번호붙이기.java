import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};   // 위, 왼쪽, 아래, 오른쪽
    static int[] dy = {0 , -1, 0, 1};
    static int d = 0;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] arags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());   // 지도의 크기 n

        visited = new boolean[n][n];
        graph = new char[n][n];
        for(int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == '0') visited[i][j] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    d = 0;
                    dfs(i, j);
                    result.add(d);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int dist : result) {
            System.out.println(dist);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        d++;

        for(int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && b >= 0 && a < n && b < n) {
                if(!visited[a][b]) dfs(a, b);
            }
        }
    }
}
