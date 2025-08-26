import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int apples = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = m;
		int result = 0;
		
		for(int i = 0; i < apples; i++) {
			int apple = Integer.parseInt(br.readLine());
			
			if(apple < start) {   // 왼쪽으로 이동
				result += start - apple;
				end -= start - apple;
				start = apple;
			} else if(apple > end) {   // 오른쪽으로 이동
				result += apple - end;
				start += apple - end;
				end = apple;
			}
		} 
		
		System.out.println(result);
	}
}
