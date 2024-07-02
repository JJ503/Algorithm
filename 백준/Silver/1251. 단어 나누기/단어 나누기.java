import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        List<String> words = new ArrayList<>();
        for (int i = 2; i < str.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(str.substring(0, j));
                StringBuilder sb2 = new StringBuilder(str.substring(j, i));
                StringBuilder sb3 = new StringBuilder(str.substring(i));

                String str1 = sb1.reverse().toString();
                String str2 = sb2.reverse().toString();
                String str3 = sb3.reverse().toString();

                words.add(str1 + str2 + str3);
            }
        }

        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
