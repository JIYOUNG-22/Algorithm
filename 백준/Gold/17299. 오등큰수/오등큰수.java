import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 수열 A의 크기 (1 <= n <= 1,000,000)

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] input = new int[n];
        int[] arrayF = new int[n];
        int temp;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            input[i] = temp;

            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        for(int i = 0; i < n; i++) {
            arrayF[i] = map.get(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arrayF[stack.peek()] < arrayF[i]) {
                result[stack.pop()] = input[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int ngf : result) {
            sb.append(ngf).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
