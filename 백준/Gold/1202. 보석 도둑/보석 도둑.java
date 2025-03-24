import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());   // 보석 개수
		int k = Integer.parseInt(st.nextToken());   // 가방 개수
		
		Jewel[] jewels = new Jewel[n];
		int[] bags = new int[k];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(a, b);
		}
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			bags[i] = a;
		}
		
		Arrays.sort(jewels);   // 무게 오름차순(같을 시 가격 내림차순)으로 정렬
		Arrays.sort(bags);      // 가방 무게 오름차순으로 정렬
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long result = 0;
		// 가방 무게가 낮은 것부터 탐색
		for(int i = 0, j = 0; i < k; i++) {
			while(j < n) {
				if(bags[i] < jewels[j].weight) break;
				pq.add(jewels[j++].price);
			}
			
			if(!pq.isEmpty()) result += pq.poll();
		}
		
		System.out.println(result);
	}
	
	static class Jewel implements Comparable<Jewel> {
		int weight;
		int price;
		
		Jewel(int a, int b) {
			this.weight = a;
			this.price = b;
		}
		
		@Override
		public int compareTo(Jewel o) {
			if(this.weight == o.weight)
				return o.price- this.price;   // 무게 같을 시 가격 내림차순
			return this.weight - o.weight;   // 무게 오름차순
		}
	}
}
