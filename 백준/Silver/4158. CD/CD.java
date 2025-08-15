import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());    // 상근이의 CD 개수
            int m = Integer.parseInt(st.nextToken());    // 선영이의 CD 개수

            // 0 0 들어오면 종료
            if (n == 0 && m == 0) {
                break;
            }

            int[] sg = new int[n];  // 상근이가 가지고 있는 CD 번호 배열 (오름차순)
            int[] sy = new int[m];  // 선영이가 가지고 있는 CD 번호 배열 (오름차순)

            for (int i = 0; i < n; i++) {
                sg[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < m; i++) {
                sy[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;  // 두 사람이 동시에 가지고 있는 CD 개수
            int x = 0, y = 0;   // 투 포인터
            while (x < n && y < m) {
                if (sg[x] == sy[y]) {
                    count++;
                    x++;
                    y++;
                } else if (sg[x] > sy[y]) y++;
                else x++;
            }
            System.out.println(count);
        }
    }
}
