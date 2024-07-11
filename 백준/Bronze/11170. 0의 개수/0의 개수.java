import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int cnt = 0; cnt < t; cnt++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());

            int answer = 0;
            for (int i = n; i <= m; i++) {
                String num = String.valueOf(i);

                for (int j = 0; j < num.length(); j++) {
                    if (num.charAt(j) == '0') {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
