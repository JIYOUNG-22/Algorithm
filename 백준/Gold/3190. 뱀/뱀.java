import java.io.*;
import java.util.*;

public class Main {

 static class Snake {
        int x;
        int y;

        public Snake(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    static int N;
    static int[][] board;
    static Queue<Snake> snakeBody = new LinkedList<>();
    static int nowX = 1, nowY = 1;
    static int time = 0;
    static String direction = "right";
    static boolean isGameOver = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());   // 보드의 크기
        int K = Integer.parseInt(br.readLine());   // 사과의 개수

        board = new int[N+1][N+1];
        for(int i = 0; i < K; i++) {   // 사과 위치 표시
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            board[row][column] = 1;
        }

        int L = Integer.parseInt(br.readLine());   // 뱀의 방향 변환 횟수

				int prevTime = 0;
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());   // X초가 끝난 뒤 방향 전환
            
            snakeMove(X-prevTime);
            if(isGameOver) break;
            
            char d = st.nextToken().charAt(0);
            changeDirection(d);
            
            prevTime = X;
        }

        while(!isGameOver) snakeMove(Integer.MAX_VALUE);

        System.out.println(time);

    }

    public static void snakeMove(int X) {
        if(time == 0) {
            snakeBody.offer(new Snake(1, 1));
            nowX = 1;
            nowY = 1;
        }

        for(int i = 0; i < X; i++) {
            switch(direction) {
                case "right" : nowY++;
                    break;
                case "down" : nowX++;
                    break;
                case "left" : nowY--;
                    break;
                case "up" : nowX--;
                    break;
            }

            // 벽에 부딪히는 상황
            if(nowX < 1 || nowX > N || nowY < 1 || nowY > N) {
                time++;
                isGameOver = true;
                return;
            }
            
            for(Snake s : snakeBody) {
              if(s.x == nowX && s.y == nowY) {
                  time++;
                  isGameOver = true;
                  return;
              }
            }

            // 해당 칸에 사과 있으면 사과 없애주고, 없다면 꼬리 하나 빼기
            if(board[nowX][nowY] == 1) {
                board[nowX][nowY] = 0;
            } else {
                snakeBody.poll();
            }

            snakeBody.offer(new Snake(nowX, nowY));

            time++;
            //System.out.println("nowX : " + nowX + " nowY : " + nowY + " time: " + time + " dir: " + direction);
        }
    }

    public static void changeDirection(char d) {
        if(d == 'L') {
            switch(direction) {
                case "right": direction = "up";
                    break;
                case "down": direction = "right";
                    break;
                case "left": direction = "down";
                    break;
                case "up": direction = "left";
                    break;
            }
        } else {
            switch(direction) {
                case "right": direction = "down";
                    break;
                case "down": direction = "left";
                    break;
                case "left": direction = "up";
                    break;
                case "up": direction = "right";
                    break;
            }
        }
    }
}