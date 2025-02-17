import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());   // A 부 배열의 합 + B 부배열 합

        int n = Integer.parseInt(br.readLine());   // 배열 A의 개수 N
        int[] arrA = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(arrA));
//        System.out.println(Arrays.toString(arrB));

        HashMap<Long, Integer> arrSumA = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < n; i++) {
                sum = 0;
            for(int j = i; j < n; j++) {
                sum += arrA[j];
                if(arrSumA.containsKey(sum)) {
                    arrSumA.put(sum, arrSumA.get(sum)+1);
                } else {
                    arrSumA.put(sum, 1);
                }
            }
        }

        HashMap<Long, Integer> arrSumB = new HashMap<>();
        for(int i = 0; i < m; i++) {
            sum = 0;
            for(int j = i; j < m; j++) {
                sum += arrB[j];
                if(arrSumB.containsKey(sum)) {
                    arrSumB.put(sum, arrSumB.get(sum)+1);
                } else {
                    arrSumB.put(sum, 1);
                }
            }
        }

        long sumB;
        long result = 0;
        for(long sumA : arrSumA.keySet()) {
            sumB = t - sumA;
            if(arrSumB.containsKey(sumB)) {
                result += (long) arrSumA.get(sumA) * arrSumB.get(sumB);
            }
        }

        System.out.println(result);
    }
}
