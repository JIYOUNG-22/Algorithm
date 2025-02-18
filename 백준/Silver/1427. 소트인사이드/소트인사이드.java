import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] arr = input.toCharArray();
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char i : arr) {
            pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb);
    }
}