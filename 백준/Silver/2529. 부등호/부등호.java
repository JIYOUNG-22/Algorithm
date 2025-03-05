import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());   // 부등호의 개수

        signs = new char[k];
        signs = br.readLine().replace(" ", "").toCharArray();

        for(int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, "");
        }

        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void dfs(int now, String str) {
        int idx = str.length();

        str = str + now;
        if(str.length() == k+1) {
            list.add(str);
            return;
        }

        for(int next = 0; next < 10; next++) {
            if(!visited[next]) {
                if((signs[idx]=='>' && now > next)||(signs[idx]=='<' && now < next)) {
                    visited[next] = true;
                    dfs(next, str);
                    visited[next] = false;
                }
            }
        }
    }
}
