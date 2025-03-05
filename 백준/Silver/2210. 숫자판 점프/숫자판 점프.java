import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board = new int[6][6]; // 1-base index
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				dfs(i, j, 0, "");
			}
		}
		
		System.out.println(set.size());
	}
	
	static void dfs(int x, int y, int depth, String str) {
		int now = board[x][y];
		str = str + now;
		if(depth == 5) {
			set.add(str);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(x + dx[i] > 0 && x + dx[i] < 6 && y + dy[i] > 0 && y + dy[i] < 6) {
				dfs(x + dx[i], y + dy[i], depth + 1, str);
			}
		}
	}
}
