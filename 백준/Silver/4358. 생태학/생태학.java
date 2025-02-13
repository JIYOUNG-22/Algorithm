import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> trees = new TreeSet<>();
        Map<String, Integer> treeCount = new HashMap<>();

        String tree = "";
        int total = 0;
        while((tree = br.readLine()) != null) {
            
            trees.add(tree);
            treeCount.put(tree, treeCount.getOrDefault(tree, 0) + 1);

            total++;
        }

        double percent;
        StringBuilder sb = new StringBuilder();
        for(String t : trees) {
            percent = (double) treeCount.get(t) * 100 / total;
            sb.append(t).append(" ").append(String.format("%.4f", percent)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}