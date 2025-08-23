import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while(tc > 0) {
			
			int change = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append(change/25).append(" ");
			change %= 25;
			sb.append(change/10).append(" ");
			change %= 10;
			sb.append(change/5).append(" ");
			change %= 5;
			sb.append(change/1);
			
			System.out.println(sb);
			
			tc--;
		} 
	}
}
