import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> smallPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bigPQ = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) {
            smallPQ.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
            bigPQ.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        if(n % 2 == 1) {
            result += smallPQ.poll();
            n--;
        }

        while(n > 0) {
            int one, two, big;
            
            if(smallPQ.size() >= 2 && bigPQ.size() >= 1) {
                one = smallPQ.poll();
                two = smallPQ.poll();
                big = bigPQ.poll();

                if(one + two > big) {
                    result += one + two;
                    bigPQ.add(big);
                } else {
                    result += big;
                    smallPQ.add(one);
                    smallPQ.add(two);
                }
            } else if(smallPQ.size() <= 1) {
                result += bigPQ.poll();
            } else {
                result += smallPQ.poll() + smallPQ.poll();
            }

            n -= 2;
        }
        System.out.println(result);
    }
}
