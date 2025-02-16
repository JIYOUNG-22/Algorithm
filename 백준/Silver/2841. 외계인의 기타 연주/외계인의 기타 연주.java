import java.io.*;
import java.util.*;

public class Main {
	
    static int n, p;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
		
		Stack<Integer>[] stacks = new Stack[6];
		for(int i = 0; i < 6; i++) {
			stacks[i] = new Stack<>();
		}

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken()) -1;
			int fret = Integer.parseInt(st.nextToken());
			
			melody(stacks[line], fret);
        }

        System.out.println(count);
    }

    public static void melody(Stack<Integer> stack, int fret) {
        while (!stack.isEmpty() && stack.peek() > fret) {
            stack.pop();
            count++;
        }

        if (stack.isEmpty()) {
            stack.push(fret);
            count++;
        } else if (stack.peek() < fret) {
            stack.push(fret);
            count++;
        }
    }
}