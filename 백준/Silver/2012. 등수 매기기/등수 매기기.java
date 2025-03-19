import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] expect = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			expect[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(expect);
		
		long diff = 0;
		for(int i = 1; i <= n; i++) {
			diff += Math.abs(i - expect[i]);
		}
		
		System.out.println(diff);
	}
}
