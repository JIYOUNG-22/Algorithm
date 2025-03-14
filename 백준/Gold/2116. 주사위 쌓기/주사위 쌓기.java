import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dice;
    static Integer[] sums = new Integer[6];;
    static int[] af = {1, 2, 3, 4};
    static int[] bd = {0, 2, 4, 5};
    static int[] ce = {0, 1, 3, 5};
    static int[] convert = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());   // 주사위 개수

        dice = new int[n][6];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 6; i++) {
            int max = 0;

            dfs(i, dice[0][i], 1, findMax(0, i));
        }

        Arrays.sort(sums, Collections.reverseOrder());

        System.out.println(sums[0]);
    }

    static void dfs(int idx, int up, int dept, int sum) {   // up:윗면 숫자, dept:몇번째 주사위인지
        if(dept == n) {
            sums[idx] = sum;
            return;
        }

        for(int i = 0; i < 6; i++) {
            if(dice[dept][i] == up) {
                sum += findMax(dept, i);
                up = dice[dept][convert[i]];
                break;
            }
        }

        dfs(idx, up, ++dept, sum);
    }

    // 옆면 중 가장 큰 값
    static int findMax(int x, int idx) {
        int maxVal = 0;
        if(idx == 0 || idx == 5) {
            for(int i = 0; i < 4; i++) {
                maxVal = Math.max(maxVal, dice[x][af[i]]);
            }
        } else if(idx == 1 || idx == 3) {
            for(int i = 0; i < 4; i++) {
                maxVal = Math.max(maxVal, dice[x][bd[i]]);
            }
        } else {
            for(int i = 0; i < 4; i++) {
                maxVal = Math.max(maxVal, dice[x][ce[i]]);
            }
        }
        return maxVal;
    }
}
