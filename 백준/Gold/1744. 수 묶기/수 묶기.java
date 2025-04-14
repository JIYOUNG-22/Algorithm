import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        boolean hasZero = false;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) hasZero = true;
            else if(num < 0) negative.offer(num);
            else positive.offer(num);
        }

        int sum = 0;
        if(negative.size() % 2 == 0) {   // 음의 개수가 짝수
            while(!negative.isEmpty()) {
                sum += negative.poll() * negative.poll();
            }
        } else {  // 음의 개수가 홀수
            if(hasZero) negative.poll();
            else sum += negative.poll();

            while(!negative.isEmpty()) {
                sum += negative.poll() * negative.poll();

            }
        }

        while (positive.size() >= 2) {
            int a = positive.poll();
            int b = positive.poll();
            if (a == 1 || b == 1) sum += (a + b);
            else sum += a * b;
        }
        if (!positive.isEmpty()) sum += positive.poll();

        System.out.println(sum);
    }
}
