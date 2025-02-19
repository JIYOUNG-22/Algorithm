import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase;
        while((testcase = Integer.parseInt(br.readLine())) != 0) {
            String min = "";
            for(int i = 0; i < testcase; i++) {
                String now = br.readLine();
                if(i==0) {
                    min = now;
                }
                if(now.toLowerCase().compareTo(min.toLowerCase()) < 0) {
                    min = now;
                }
            }
            sb.append(min).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
