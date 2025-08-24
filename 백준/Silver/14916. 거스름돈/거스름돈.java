import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int change = Integer.parseInt(br.readLine());

      if(change / 5 == 0 && (change%5)%2 == 1) System.out.println(-1);
      else if((change%5)%2==0) System.out.println(change/5 + (change%5)/2);
      else System.out.println(change/5 - 1 + (5+change%5)/2);
	}
}
