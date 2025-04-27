import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        colors = new int[m];
        for(int i = 0; i < m; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            if(max < colors[i]) max = colors[i];
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int low = 1;
        int high = max;

        while(low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for(int c : colors) {
                if(c % mid == 0) sum += c / mid;
                else sum += c / mid + 1;
            }

            if(n >= sum) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}
