import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 학생 수 n
		
		Queue<Integer> queue = new ArrayDeque<>();
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int number = 1;
		while(number < n) {
			if(queue.contains(number)) {
				while(queue.peek() != number) {
					stack.push(queue.poll());
				}
				queue.poll();
			} else {
				if(stack.peek() == number) stack.pop();
				else break;
			}
			number++;
		}
		
		System.out.println(number == n ? "Nice" : "Sad");
	}
}