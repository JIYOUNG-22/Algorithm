import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int col, row;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        graph = new int[row][col];
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isP = bfs();

        if(isP) System.out.println("Yes");
        else System.out.println("No");
    }

    public static Boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == col - 1 && now[1] == row - 1) return true;

            for(int i = 0; i < 2; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX < col && nextY < row && graph[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    q.offer(new int[] {nextX, nextY});
                    visited[nextY][nextX] = true;
                }
            }
        }

        return false;
    }
}
