import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dwarfs = new int[9];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sumOfNine = 0;
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sumOfNine += dwarfs[i];
		}
		
		int sumOfTwo = sumOfNine - 100;
		Arrays.sort(dwarfs);
		
		int left = 0, right = 8;
		while(true) {
			if(dwarfs[left] + dwarfs[right] < sumOfTwo) {
				left++;
			} else if(dwarfs[left] + dwarfs[right] > sumOfTwo) {
				right--;
			} else {
				break;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(i==left || i==right) continue;
			System.out.println(dwarfs[i]);
		}
	}
	
}