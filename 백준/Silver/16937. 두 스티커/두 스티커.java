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

        ArrayList<Sticker> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

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

                if(Math.max(a, d) <= h && b + c <= w || Math.max(a, d) <= w && b + c <= h) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                } else if(Math.max(a, c) <= h && b + d <= w || Math.max(a, c) <= w && b + d <= h) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                } else if(Math.max(b, c) <= h && a + d <= w || Math.max(b, c) <= w && a + d <= h) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                } else if(Math.max(b, d) <= h && a + c <= w || Math.max(b, d) <= w && a + c <= h) {
                    maxArea = Math.max(maxArea, a*b + c*d);
                }
            }
        }

        System.out.println(maxArea);
    }
}
