
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 수열 A의 크기 N (1 <= N <= 1,000,000)
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        int[] output = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            output[i] = -1;
        }

        for(int i = 0; i < N; i++) {

            while(!stack.isEmpty() && input[stack.peek()] < input[i]) {
                int idx = stack.pop();
                output[idx] = input[i];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int a : output) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
