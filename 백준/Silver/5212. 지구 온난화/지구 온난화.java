import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static char[][] map;
    static char[][] futureMap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        futureMap = new char[row][col];
        for(int i = 0; i < row; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            futureMap[i] = str.toCharArray();
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 'X') {
                    if(isChange(i, j)) futureMap[i][j] = '.';
                }
            }
        }

        int startX = 0, endX = 0;
        int startY = 0, endY = 0;

        label1:
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(futureMap[i][j] == 'X') {
                    startX = i;
                    break label1;
                }
            }
        }

        label2:
        for(int i = row - 1; i >= 0; i--) {
            for(int j = 0; j < col; j++) {
                if(futureMap[i][j] == 'X') {
                    endX = i;
                    break label2;
                }
            }
        }

        label3:
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if(futureMap[j][i] == 'X') {
                    startY = i;
                    break label3;
                }
            }
        }

        label4:
        for(int i = col - 1; i >= 0; i--) {
            for(int j = 0; j < row; j++) {
                if(futureMap[j][i] == 'X') {
                    endY = i;
                    break label4;
                }
            }
        }

        for(int i = startX; i <= endX; i++) {
            for(int j = startY; j <= endY; j++) {
                System.out.print(futureMap[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isChange(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            if(x + dx[i] < 0 || x + dx[i] >= row || y + dy[i] < 0 || y + dy[i] >= col)
                cnt++;
			else if (map[x+dx[i]][y+dy[i]] == '.')
                    cnt++;
        }
        if(cnt >= 3) return true;
        return false;
        }
}
