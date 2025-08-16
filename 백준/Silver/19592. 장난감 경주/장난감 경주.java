import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, max;
    static double dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        while(testcase > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dist = Double.parseDouble(st.nextToken());
            max = Integer.parseInt(st.nextToken());

            int[] velocity = new int[n];
            PriorityQueue<Double> time = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                velocity[i] = Integer.parseInt(st.nextToken());
                if(i != n-1) time.add(dist / velocity[i]);
            }

            double first = time.peek();
            //System.out.println("testcase : " + testcase + " n : " + n + " dist : " + dist + " max : " + max + " first : " + first);
            if(dist/velocity[n-1] < first) {
                System.out.println(0);
                testcase--;
                continue;
            } else if(1 + (dist-max)/velocity[n-1] >= first) {
                System.out.println(-1);
                testcase--;
                continue;
            } else {
                binarySearch(velocity[n-1], first);
            }

            testcase--;
        }
    }

    public static void binarySearch(int velocity, double baseTime) {
        int min = 0, mid = 0, end = max;

        while(min <= end) {
            mid = (min + end) / 2;
            //System.out.println("min : " + min + " max : " + max + " mid : " + mid);
            if (1 + (dist - mid) / velocity >= baseTime) {
                min = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(min);
    }
}
