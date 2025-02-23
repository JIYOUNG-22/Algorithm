import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			if(queue.size() == 1) {
				sb.append(queue.poll()).append(">");
			} else {
				sb.append(queue.poll()).append(", ");
			}
		}
		
		System.out.println(sb.toString());
	}
}