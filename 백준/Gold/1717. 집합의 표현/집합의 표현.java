import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0) {
                union(a, b);
            } else {
                if(isUnion(a, b)) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
//                System.out.println(isUnion(a, b) ? "yes" : "no");
            }
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return true;
        else return false;
    }

}