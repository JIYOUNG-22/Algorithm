import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());   // 수열 A의 크기
		
		int[] originArr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			originArr[i] = num;
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int[] countArr = new int[n];
		for(int i = 0; i < n; i++) {
			countArr[i] = map.get(originArr[i]);
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			if(stack.isEmpty()) stack.push(i);
			
			while(!stack.isEmpty() && countArr[stack.peek()] < countArr[i]) {
				result[stack.pop()] = originArr[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) 
			result[stack.pop()] = -1;
		
	 StringBuilder sb = new StringBuilder();
      for(int i : result) {
          sb.append(i).append(" ");
      }
      
    System.out.println(sb.toString().trim());
	}
}