import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<int[]> arrayList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			arrayList.add(new int[]{weight, height});
		}

		int rank;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			rank = 0;
			for (int j = 0; j < n; j++) {
                if(!(i==j)){
                    int a = arrayList.get(i)[0];
                    int b = arrayList.get(i)[1];
                    if (a < arrayList.get(j)[0] && b < arrayList.get(j)[1]) rank++;
                }
            }
			sb.append(rank + 1).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}