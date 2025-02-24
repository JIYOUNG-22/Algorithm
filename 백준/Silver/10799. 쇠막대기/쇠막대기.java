import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				if(stack.isEmpty() || stack.peek() == '(') {
					stack.push('(');
				} else {
					stack.pop();
					stack.push('(');
				}	
			} else {
				if(stack.peek() == '(') {
					stack.pop();
					count += stack.size();
					stack.push(')');
				} else {
					stack.pop();
					count++;
					stack.pop();
					stack.push(')');
				}
			}
		}
		System.out.println(count);
	}
}