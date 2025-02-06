import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 학생의 수 n
		
		PriorityQueue<String> minHeap = new PriorityQueue<>();
		PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken());
			
			temp = 0;
			temp += Integer.parseInt(st.nextToken());
			temp += (100 * Integer.parseInt(st.nextToken()));
			temp += (10000 * Integer.parseInt(st.nextToken()));
			sb.insert(0, temp);
			
			minHeap.add(sb.toString());
			maxHeap.add(sb.toString());
			
			sb.setLength(0);	// sb 초기화
		}
		
		System.out.println(maxHeap.poll().substring(8));
		System.out.println(minHeap.poll().substring(8));
		
	}
}