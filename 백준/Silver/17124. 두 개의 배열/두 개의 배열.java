import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(tc > 0) {
            st = new StringTokenizer(br.readLine());
            int lengthA = Integer.parseInt(st.nextToken());
            int lengthB = Integer.parseInt(st.nextToken());

            int[] A = new int[lengthA];
            int[] B = new int[lengthB];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < lengthA; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < lengthB; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            int[] C = new int[lengthA];
            for(int i = 0; i < lengthA; i++) {
                int num = A[i];

                boolean check = false;
                int start = 0;
                int end = lengthB - 1;
                while(start + 1 < end) {
                    int mid = (start + end) / 2;

                    if(num == B[mid]) {
                        check = true;
                        C[i] = num;
                        break;
                    } else if(num > B[mid]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }

                if(!check) {
                    if(Math.abs(num - B[start]) == Math.abs(num - B[end])) C[i] = B[start];
                    else if(Math.abs(num - B[start]) < Math.abs(num - B[end])) C[i] = B[start];
                    else if(Math.abs(num - B[start]) > Math.abs(num - B[end])) C[i] = B[end];
                }
            }
            long result = 0;
            for(int j = 0; j < lengthA; j++) {
                result += C[j];
            }
            System.out.println(result);
            tc--;
        }
    }
}
