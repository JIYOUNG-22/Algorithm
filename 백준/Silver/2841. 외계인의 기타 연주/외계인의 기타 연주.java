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

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        Stack<Integer> stack5 = new Stack<>();
        Stack<Integer> stack6 = new Stack<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch(Integer.parseInt(st.nextToken())) {
                case 1:
                    melody(stack1, Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    melody(stack2, Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    melody(stack3, Integer.parseInt(st.nextToken()));
                    break;
                case 4:
                    melody(stack4, Integer.parseInt(st.nextToken()));
                    break;
                case 5:
                    melody(stack5, Integer.parseInt(st.nextToken()));
                    break;
                case 6:
                    melody(stack6, Integer.parseInt(st.nextToken()));
                    break;
            }
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