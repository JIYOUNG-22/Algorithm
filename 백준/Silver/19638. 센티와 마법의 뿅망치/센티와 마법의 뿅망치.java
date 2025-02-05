import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int n = Integer.parseInt(st.nextToken());	// 거인 나라의 인구수
        int centi = Integer.parseInt(st.nextToken());	// 센티의 키
        int t = Integer.parseInt(st.nextToken());	// 뿅망치 횟수 제한

        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 각 거인의 키 입력 받기
        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;  // 뿅망치 사용 횟수
        while(t>0) {
            if(pq.peek() < centi || pq.peek() == 1) break;
            pq.add(pq.poll() / 2);
            count++;
            t--;
        }

        if(pq.peek() < centi) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(pq.peek());
        }

    }

}
