import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] money;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int start = 0, end = 0;
        money = new int[n];
        for(int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            end += money[i];
            start = Math.max(start, money[i]);
        }

        while(start < end) {
            int mid = (start + end) / 2;

            if(count(mid) > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    public static int count(int mid) {
        int count = 1;
        int withdrawl = mid;

        for(int i : money) {
            withdrawl -= i;
            // 돈이 모자라면 현금을 다시 인출
            if(withdrawl < 0) {
                count++;
                withdrawl = mid - i;
            }
        }

        return count;
    }
}
