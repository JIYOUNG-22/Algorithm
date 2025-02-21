import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());   // 사람의 수 N
		
		int[] cards = new int[5];
		int[] result = new int[N+1];
		
		for(int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				cards[j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for(int a = 0; a < 3; a++) {
				for(int b = a + 1; b < 4; b++) {
					for(int c = b + 1; c < 5; c++) {
						sum = Math.max(sum, (cards[a] + cards[b] + cards[c]) % 10);
					}
				}
			}
			result[i] = sum;
		}
		
		int max = result[1];
		int answer = 1;
		for(int i = 2; i < N + 1; i++) {
			if(max <= result[i]) {
				max = result[i];
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
}