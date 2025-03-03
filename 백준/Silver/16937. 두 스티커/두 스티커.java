import java.io.*;
import java.util.*;

public class Main {
    static class Sticker {
        int x;
        int y;

        Sticker(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int max = Math.max(h, w);
        int min = Math.min(h, w);

        ArrayList<Sticker> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(0);
            return;
        }
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x <= Math.max(h, w) && y <= Math.max(h, w)) {
                list.add(new Sticker(x, y));
            }
        }
        
        int maxArea = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                int a = list.get(i).x;
                int b = list.get(i).y;
                int c = list.get(j).x;
                int d = list.get(j).y;

                if(Math.max(a, d) <= max && b + c <= min || Math.max(a, d) <= min && b + c <= max) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                } else if(Math.max(a, c) <= max && b + d <= min || Math.max(a, c) <= min && b + d <= max) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                } else if(Math.max(b, c) <= max && a + d <= min || Math.max(b, c) <= min && a + d <= max) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                } else if(Math.max(b, d) <= max && a + c <= min || Math.max(b, d) <= min && a + c <= max) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                }
            }
        }

        System.out.println(maxArea);
    }
}
