import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 사람의 수 n

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++) {
            int key = arr[i];
            for(int j = i-1; j >= 0; j--) {
                if(key < arr[j]) {
                    arr[j+1] = arr[j];
                    if(j==0) arr[0] = key;
                }
                else {
                    arr[j+1] = key;
                    break;
                }
            }
        }

       int  sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (n-i) * arr[i];
        }
        
        System.out.println(sum);
    }
}