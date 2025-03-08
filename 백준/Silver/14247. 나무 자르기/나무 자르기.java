import java.io.*;
import java.util.*;

public class Main {
	static class Tree {
		int height;
		int grow;
		
		Tree (int a, int b) {
			this.height = a;
			this.grow = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] heightArr = new int[n];
		int[] growArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			heightArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			growArr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Tree> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			Tree tree = new Tree(heightArr[i], growArr[i]);
			list.add(tree);
		}
		
		Collections.sort(list, (o1, o2) -> o1.grow - o2.grow);
		
		long result = 0;
		for(int i = 0; i < n; i++) {
			result += list.get(i).height + list.get(i).grow * i;
		}
		
		System.out.println(result);
	}
}
