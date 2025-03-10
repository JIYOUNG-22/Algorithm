import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());   // 공연장 가로
		int length = Integer.parseInt(st.nextToken());  // 공연장 세로
		int k = Integer.parseInt(br.readLine());        // 대기 번호
		
		if(k > width * length) {
			System.out.println(0);
			return;
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		boolean[][] visited = new boolean[length][width];
		
		int cnt = 0, x = length - 1, y = 0, dir = 0;
		while(++cnt != k) {
			visited[x][y] = true;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= length || ny >= width || visited[nx][ny]) {
				dir = ++dir % 4;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			
			x = nx;
			y = ny;
		}
		
		System.out.println((y + 1) + " " + (length - x));
	}
}
