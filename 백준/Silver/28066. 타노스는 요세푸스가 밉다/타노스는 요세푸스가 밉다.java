import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new ArrayDeque<>();
        for(long i = 1; i <= n; i++) {
            queue.add(i);
        }

        long first = queue.peek();
        while(queue.size() >= k) {

            queue.add(queue.poll());
            for(long i = 0; i < k-1; i++) {
                queue.poll();
            }
            first = queue.peek();
        }

        System.out.println(first);
    }

}
