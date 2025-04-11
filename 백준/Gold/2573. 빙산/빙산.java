import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] ices;
    static int[][] afterYear;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ices = new int[n][m];
        afterYear = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                ices[i][j] = Integer.parseInt(st.nextToken());
                afterYear[i][j] = ices[i][j];
            }
        }

        int years = 0;
        while(true) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(ices[i][j] != 0) {
                        for(int k = 0; k < 4; k++) {
                            int a = i + dx[k];
                            int b = j + dy[k];
                            if(a >= 0 && a < n && b >= 0 && b < m) {
                                if(ices[a][b] == 0) {
                                    if(afterYear[i][j]-1 <= 0) afterYear[i][j] = 0;
                                    else afterYear[i][j]--;
                                }
                            }
                        }
                    }
                }
            }
            
            years++;
            boolean isDone = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    ices[i][j] = afterYear[i][j];
                    if(ices[i][j] != 0) isDone = false;
                }
            }

            if(isDone) {
                years = 0;
                break;
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(ices[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                    if(cnt >= 2) break;
                }
            }
            if(cnt >= 2) break;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    visited[i][j] = false;
                }
            }
        }
        System.out.println(years);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        int nextX, nextY;
        for(int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;

            if(ices[nextX][nextY] != 0 && !visited[nextX][nextY])
                dfs(nextX, nextY);
        }

    }

}