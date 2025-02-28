import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] party;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 사람의 수 n
        int m = Integer.parseInt(st.nextToken());   // 파티의 수 m

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());   // 진실을 아는 사람의 수 t
        int[] knownPeople = new int[t];
        for(int i = 0; i < t; i++) {
            knownPeople[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        party = new ArrayList[m + 1];
        for(int i = 1; i <= m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   // 해당 파티에 참석한 사람의 수 p
            for(int j = 0; j < p; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= m; i++) {
            int first_man = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++) {
                union(first_man, party[i].get(j));
            }  
        }
        
        int count = 0;
        for(int i = 1; i <= m; i++) {
            int leader = party[i].get(0);
            boolean flag = true;
            for(int j = 0; j < t; j++) {
                if(isSame(leader, knownPeople[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a; 
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static boolean isSame(int a, int b) {
        if(find(a) == find(b)) return true;   
        else return false;
    }
}
