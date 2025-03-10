import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());   // 원생의 수
		int k = Integer.parseInt(st.nextToken());   // 조의 개수
		
		List<Integer> tall = new ArrayList<>();
		List<Integer> subTall = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			tall.add(Integer.parseInt(st.nextToken()));
		}
		
		// 키 차이 구하기
		for(int i = 0; i < n - 1; i++) {
			subTall.add(tall.get(i + 1) - tall.get(i));
		}
		
		Collections.sort(subTall);
		
		int answer = 0;
		for(int i = 0; i < n - k; i++) {
			answer += subTall.get(i);
		}
		
		System.out.println(answer);
	}
}
