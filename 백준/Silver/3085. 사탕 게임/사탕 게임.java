import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] board = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int maxCandies = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j < n - 1) {
					swap(board, i, j, i, j+1);
					maxCandies = Math.max(maxCandies, calculateMaxCandies(board, n));
					swap(board, i, j, i, j+1);
				}
				
				if(i < n - 1) {
					swap(board, i, j, i+1, j);
					maxCandies = Math.max(maxCandies, calculateMaxCandies(board, n));
					swap(board, i, j, i+1, j);
				}
			}
		}
		System.out.println(maxCandies);
	}
	
	private static void swap(char[][] board, int x1, int y1, int x2, int y2) {
		char temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}
	
	private static int calculateMaxCandies(char[][] board, int n) {
		int maxLen = 0;
		
		for(int i = 0; i < n; i++) {
			int countRow = 1;
			int countCol = 1;
			
			for(int j = 1; j < n; j++) {
				if(board[i][j] == board[i][j-1]) {
					countRow++;
				} else {
					maxLen = Math.max(maxLen, countRow);
					countRow = 1;
				}
				
				if(board[j][i] == board[j - 1][i]) {
					countCol++;
				} else {
					maxLen = Math.max(maxLen, countCol);
					countCol = 1;
				}
			}
			maxLen = Math.max(maxLen, countRow);
			maxLen = Math.max(maxLen, countCol);
		}
		
		return maxLen;
	}
}
