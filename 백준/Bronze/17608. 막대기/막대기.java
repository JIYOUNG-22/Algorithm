import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] poles = new int[n];
		for(int i = 0; i < n; i++) {
			poles[i] = Integer.parseInt(br.readLine());
		}
		
		int ref = poles[n-1];
		int ans = 1;
		for(int i = n-2; i >= 0; i--) {
			if(poles[i] > ref) {
				ans++;
				ref = poles[i];
			}
		}
		
		System.out.println(ans);
		
	}
}
