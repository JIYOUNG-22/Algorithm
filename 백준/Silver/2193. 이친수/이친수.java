import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1 || N == 2) {
			System.out.println(1);
			return;
		}
		
		long[] A = new long[N + 1];
		A[1] = 1;
		A[2] = 1;
		
		for(int i = 3; i < N + 1; i++) {
			A[i] = A[i - 2] + A[i - 1];
		}
		
		System.out.println(A[N]);
	}
}