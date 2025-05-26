class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        boolean[][] graph = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(arr1[i] % 2 == 1) graph[i][j] = true;
                arr1[i] = arr1[i] / 2;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(arr2[i] % 2 == 1) graph[i][j] = true;
                arr2[i] = arr2[i] / 2;
            }
        }
        
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(graph[i][j]) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}