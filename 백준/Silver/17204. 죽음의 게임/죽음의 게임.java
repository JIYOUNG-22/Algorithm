import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
    static int[] point;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());	// 게임 참여자 수
        k = Integer.parseInt(st.nextToken());	// 보성이의 번호 (index)

        point = new int[n];
        for(int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        int dead = 0, count = 0;
        Set<Integer> set = new HashSet<>();
		set.add(0);
        while(dead != k) {
            dead = point[dead];
            count++;

            if(set.contains(dead)) {
                count = -1;
                break;
            }
            set.add(dead);
        }

        System.out.println(count);
    }
}