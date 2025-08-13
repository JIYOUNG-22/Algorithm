import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<String> list = new LinkedList<>();
        for(int i = 2; i < str.length(); i++) {
            for(int j = 1; j < i; j++) {
                StringBuilder strTemp1 = new StringBuilder(str.substring(0, j));
                StringBuilder strTemp2 = new StringBuilder(str.substring(j, i));
                StringBuilder strTemp3 = new StringBuilder(str.substring(i));
                String str1 = strTemp1.reverse().toString();
                String str2 = strTemp2.reverse().toString();
                String str3 = strTemp3.reverse().toString();
                list.add(str1 + str2 + str3);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
