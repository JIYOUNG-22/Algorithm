import java.io.*;
import java.util.*;

public class Main {

	static int[] sorted;
	static long result = 0; 
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		sorted = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(A, 0, A.length - 1);
		
		//System.out.println(Arrays.toString(A));
		System.out.println(result);
	}
	
	public static void merge_sort(int[] A, int left, int right) {
		if(left == right) return;
		
		int mid = (left + right) / 2;
		
		merge_sort(A, left, mid);
		merge_sort(A, mid + 1, right);
		
		merge(A, left, mid, right);
	}
	
	public static void merge(int[] A, int left, int mid, int right) {
		int l = left; 
		int r = mid + 1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			if(A[l] <= A[r]) {
				sorted[idx] = A[l];
				idx++;
				l++;
			} else {
				sorted[idx] = A[r];
				result += (r - idx);
				idx++;
				r++;
			}
		}
		
		if(l <= mid) {
			while(l <= mid) {
				sorted[idx] = A[l];
				idx++;
				l++;
			}
		} else {
			while(r <= right) {
				sorted[idx] = A[r];
				idx++;
				r++;
			}
		}
		
		for(int i = left; i <= right; i++) {
			A[i] = sorted[i];
		}
	}
}
