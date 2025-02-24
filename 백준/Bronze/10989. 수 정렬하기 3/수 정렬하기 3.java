import java.io.*;
import java.util.*;

public class Main {
	  // 10진수 기준으로 구현
    static int BUCKET_NUM = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   // 수의 개수 N

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}