import java.io.*;
import java.util.*;

public class Main {
	static int n, s;
	static int[] numbers;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}	
		
		dfs(0, 0);
		
		System.out.println(s == 0 ? count - 1 : count);
	}
	
	static void dfs(int depth, int sum) {
		if(depth == n) {
			if(sum == s) {
				count++;
			}
			return;
		}
		
		// 현재 원소를 포함하는 경우
		dfs(depth + 1, sum + numbers[depth]);
		
		// 현재 원소를 포함하지 않는 경우
		dfs(depth + 1, sum);
		
	}
}
