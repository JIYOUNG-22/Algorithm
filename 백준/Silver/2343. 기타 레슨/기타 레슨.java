import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            if(min < lectures[i]) min = lectures[i];
            max += lectures[i];
        }

        System.out.println(blu_ray(min, max));

    }

    static int blu_ray(int low, int high) {
        while(low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0, sum = 0;
            for(int i = 0; i < n; i++) {
                if(sum + lectures[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += lectures[i];
            }
            if(sum != 0) cnt++;
            if(cnt > m) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
