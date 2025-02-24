import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static boolean isTrue;

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());   // 사람의 수 N
      int M = Integer.parseInt(st.nextToken());   // 친구 관계의 수 M

      // graph, visited, dist 초기화
      graph = new ArrayList[N];   // 0-base index
      for(int i = 0; i < N; i++) {
          graph[i] = new ArrayList<Integer>();
      }
      visited = new boolean[N];

      // 입력 처리 - graph 관계 표현
      for(int i = 0; i < M; i++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());

          graph[a].add(b);
          graph[b].add(a);
      }

      // DFS
      for(int i = 0; i < N; i++) {
          dfs(i, 0);
          if(isTrue) break;
      }

      System.out.println(isTrue ? 1 : 0);
  }

  private static void dfs(int nowNode, int depth) {
      if(depth == 4) {
          isTrue = true;
          return;
      }
      visited[nowNode] = true;

      for(int nextNode : graph[nowNode]) {
          if(!visited[nextNode]) dfs(nextNode, depth + 1);
      }

      visited[nowNode] = false;
  }
}
