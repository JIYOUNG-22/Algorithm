import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] array = new int[5];
        for(int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4-i; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    
                    sb.append(array[0]).append(" ").append(array[1]).append(" ").append(array[2]).append(" ").append(array[3]).append(" ").append(array[4]);
                    System.out.println(sb);
                    sb.setLength(0);

                    if(array[0]==1 && array[1]==2 && array[2]==3 && array[3]==4 && array[4]==5)
                    break;
                }

            }    
        }
    }
}