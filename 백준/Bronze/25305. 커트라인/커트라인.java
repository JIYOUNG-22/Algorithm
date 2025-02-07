import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < k-1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
	}
}