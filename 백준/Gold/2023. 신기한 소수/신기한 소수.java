import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] graph = new ArrayList[9];
    static int[] add = {1,3,7,9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   // N자리 수

        // graph 초기화
        for(int i = 1; i <= 8; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // N = 1인 경우 입력해주기
        graph[1].add(2);
        graph[1].add(3);
        graph[1].add(5);
        graph[1].add(7);

        StringBuilder sb = new StringBuilder();
        if(N == 1) {
            for(int i : graph[1]) {
                sb.append(i).append("\n");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i = 2; i <= N; i++) {
            dfs(i);
        }

        for(int i : graph[N]) {
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int idx) {
        for(int num : graph[idx - 1]) {
            for(int i = 0; i < 4; i++) {
                int temp = num * 10 + add[i];
                if(isPrime(temp)) {
                    graph[idx].add(temp);
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
