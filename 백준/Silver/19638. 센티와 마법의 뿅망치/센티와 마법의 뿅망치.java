import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 거인 나라 인구수 n
		int centiHeight = Integer.parseInt(st.nextToken());	// 센티의 키
		int t = Integer.parseInt(st.nextToken());	// 최대 뿅망치 사용 횟수
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
		for(int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int count = 0;
		for(int i = 0; i < t; i++) {
			if(pq.peek() == 1 || pq.peek() < centiHeight) break;
			else {
				pq.offer(pq.poll()/2);
				count++;
			}
		}
		
		if(pq.peek() < centiHeight) {
			System.out.println("YES");
			System.out.println(count);
		} else {
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}
}