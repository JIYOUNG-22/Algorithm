import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   // 탑의 수 N

        int[] towers = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N+1];
        for(int i = N; i > 0; i--) {

            while(!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                result[stack.pop()] = i;
            }

            stack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}