import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T > 0) {
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.push('(');
				} else {
					if(stack.isEmpty()) {
						stack.push(')');
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty()) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
			T--;
		}
		
		System.out.println(sb.toString().trim());
	}
}
