import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] tomatoes;
    static int[][] dist;
    static Queue<Tomato> ripeT = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   // 상자 가로 칸의 수
        n = Integer.parseInt(st.nextToken());   // 상자 세로 칸의 수

        int zero = 0;
        tomatoes = new int[n][m];
        dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 0) zero++;
                else if(tomatoes[i][j] == 1) {
                    ripeT.offer(new Tomato(i, j));
                }
            }
        }

        if(zero == 0) {   // 모든 토마토가 익어있는 상태
            System.out.println(0);
            return;
        }

        int result = 0;
        while(!ripeT.isEmpty()) {
            Tomato t = ripeT.poll();
            int nowX = t.x;
            int nowY = t.y;

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if(tomatoes[nextX][nextY] == 0) {
                        tomatoes[nextX][nextY] = 1;
                        ripeT.offer(new Tomato(nextX, nextY));
                        zero--;
                        dist[nextX][nextY] = dist[nowX][nowY] + 1;
                        result = Math.max(result, dist[nextX][nextY]);
                    }
                }
            }
        }

        System.out.println(zero > 0 ? -1 : result);
    }

    static class Tomato {
        int x, y;

        Tomato(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }
}
