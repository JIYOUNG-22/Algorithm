import java.io.*;
import java.util.*;

public class Main {

	static class Lecture implements Comparable<Lecture> {
		int start;
		int end;
		
		public Lecture(int s, int t) {
			this.start = s;
			this.end = t;
		}
		
		@Override
		public int compareTo(Lecture l) {
			return this.start - l.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());   // 강의 개수 N
		
		List<Lecture> lectures = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lectures.add(new Lecture(start, end));
		}
		
		Collections.sort(lectures);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(Lecture l : lectures) {
			if(pq.isEmpty()) {
				pq.add(l.end);
				continue;
			}
			
			if(l.start >= pq.peek()) {
				pq.poll();
				pq.offer(l.end);
			} else {
				pq.offer(l.end);
			}
		}
		
		System.out.println(pq.size());
	}
}
