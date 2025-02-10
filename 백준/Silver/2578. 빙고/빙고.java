import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingoBoard = new int[5][5];
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                bingoBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        int bingo = 0;
        while(bingo < 3) {
            int called = queue.poll();

            label:
            for(int j = 0; j < 5; j++) {
               for(int k = 0; k < 5; k++) {
                   if(bingoBoard[j][k] == called) {
                       bingoBoard[j][k] = 0;
                       break label;
                   }
               }
            }

            bingo = 0;
            for(int j = 0; j < 5; j++) {
                if(bingoBoard[j][0] == 0 && bingoBoard[j][1] == 0 && bingoBoard[j][2] == 0 && bingoBoard[j][3] == 0 && bingoBoard[j][4] == 0)
                    bingo++;
            }
            for(int j = 0; j < 5; j++) {
                if(bingoBoard[0][j] == 0 && bingoBoard[1][j] == 0 && bingoBoard[2][j] == 0 && bingoBoard[3][j] == 0 && bingoBoard[4][j] == 0)
                    bingo++;
            }
            if(bingoBoard[0][0] == 0 && bingoBoard[1][1] == 0 && bingoBoard[2][2] == 0 && bingoBoard[3][3] == 0 && bingoBoard[4][4] == 0)
                bingo++;
            if(bingoBoard[0][4] == 0 && bingoBoard[1][3] == 0 && bingoBoard[2][2] == 0 && bingoBoard[3][1] == 0 && bingoBoard[4][0] == 0)
                bingo++;
        }

        System.out.println(25 - queue.size());

    }
}
