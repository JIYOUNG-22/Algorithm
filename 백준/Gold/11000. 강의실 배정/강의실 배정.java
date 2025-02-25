import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());   // 강의 개수 N
		
		List<Map<Integer, Integer>> classes = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			Map<Integer, Integer> classInfo = new HashMap<>();
      classInfo.put(start, end);
      classes.add(classInfo);
		}
		
		Collections.sort(classes, new Comparator<Map<Integer, Integer>>() {
			@Override
			public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
				return o1.keySet().iterator().next().compareTo(o2.keySet().iterator().next());
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int result = 1;
		for(Map<Integer, Integer> classInfo : classes) {
			Map.Entry<Integer, Integer> entry = classInfo.entrySet().iterator().next();
			int start = entry.getKey();
			int end = entry.getValue();
		
			if(pq.isEmpty()) {
				pq.add(end);
				continue;
			}
			
			if(start >= pq.peek()) {
				pq.poll();
				pq.offer(end);
			} else {
				pq.offer(end);
				result++;
			}
		}
		
		System.out.println(result);
	}
}
