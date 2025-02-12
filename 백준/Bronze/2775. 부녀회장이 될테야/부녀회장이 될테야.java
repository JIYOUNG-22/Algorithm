import java.io.*;
import java.util.*;

public class Main {
	static int[][] apt = new int[15][15];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int i = 0; i < 15; i++) {
			apt[0][i] = i;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				apt[i][j] = apt[i][j - 1] + apt[i-1][j];
			}
		}
		
		for(int i = 0; i < testcase; i++) {
			int floor = Integer.parseInt(br.readLine());
			int number = Integer.parseInt(br.readLine());
			sb.append(apt[floor][number]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}