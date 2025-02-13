import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dp = new int[30][30];

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(testcase > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());	// west < east
			
			sb.append(combi(east, west)).append("\n");
			testcase--;
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public static int combi(int n, int r) {	// n개 중에 r개를 뽑는다
		
		if(dp[n][r] > 0) {	// 이미 탐색했던 경우 바로 반환
			return dp[n][r];
		}
		
		if(n == r || r ==0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = combi(n - 1, r - 1) + combi(n-1, r);
	}
}