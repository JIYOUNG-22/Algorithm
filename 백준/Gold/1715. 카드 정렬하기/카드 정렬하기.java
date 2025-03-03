import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());   // 숫자 묶음의 개수
		if(n==1) {
          System.out.println(0);
          return;
        }
    
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		while(pq.size() != 1) {
			int a = pq.poll();
			int b = pq.poll();
			pq.add(a+b);
			result += (a+b);
		}
		
		System.out.println(result);
	}
}