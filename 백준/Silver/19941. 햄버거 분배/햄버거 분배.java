import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] location;
        boolean[] eaten = new boolean[n];
        location = br.readLine().toCharArray();

        for(int i = 0; i < n; i++) {
            if(location[i] == 'P') eaten[i] = true;
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(location[i] == 'P') {
                for(int j = 0; j <= 2 * k; j++) {
                    if(i + j - k >= 0 && i + j - k < n && !eaten[i + j - k]) {
                        result++;
                        eaten[i+j-k] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
