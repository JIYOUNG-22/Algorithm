import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = 0;
		
		// 보드의 각 글자 탐색
		for(int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if(temp == 'X') count++;
			else {
				if(!check(count)) break;
				ans.append(".");
				count = 0;
			}
		}
		
		if(!ans.equals("-1") && str.charAt(str.length()-1) == 'X') check(count);
		
		System.out.println(ans);
	}
	
	static boolean check(int count) {
		String A = "AAAA", B = "BB";
		if(count % 4 == 0) {
			for(int j = 0; j < count/4; j++) ans.append(A);
		} else if(count % 4 == 2) {
			for(int j = 0; j < count / 4; j++) ans.append(A);
			ans.append(B);
		} else if(count == 2) {
			ans.append(B);
		} else {
			ans = new StringBuilder("-1");
			return false;
		}
		
		return true;
	}
}
