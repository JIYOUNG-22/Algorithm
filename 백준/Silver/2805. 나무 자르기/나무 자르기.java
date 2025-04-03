import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 나무의 수 n
        m = Long.parseLong(st.nextToken());   // 나무의 길이 m

        long[] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(trees);

        long result = binarySearch(trees);

        System.out.println(result);
    }

    public static long binarySearch(long[] trees) {
        long low = 0;
        long high = trees[trees.length - 1];
        long best = 0;

        while(low <= high) {
            long mid = (low + high) / 2;
            long cut = cutHeight(mid, trees);

            if(cut >= m) {
                best = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }

        // System.out.println("low : " + low + " high : " + high);
        return best;
    }

    public static long cutHeight(long h, long[] trees) {
        long sum = 0;
        for(int i = trees.length - 1; i >= 0; i--) {
            if(trees[i] > h) sum += (trees[i] - h);
            else break;
        }

        return sum;
    }
}
