import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());

        String a = str.nextToken();
        String b = str.nextToken();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int count = 0;

            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    count++;
                }
            }

            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
