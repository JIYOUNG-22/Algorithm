import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 배열 크기
		int k = Integer.parseInt(st.nextToken());	// 합이 k
		
		long count = 0;	// 합이 K인 부분합의 개수
		long sum = 0;
		HashMap<Long, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0L, 1);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(st.nextToken());
			
			count += prefixSum.getOrDefault(sum - k, 0);
			
			prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
		}
		System.out.println(count);
	}
}