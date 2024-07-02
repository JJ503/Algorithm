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

        for (int idx = 0; idx < t; idx++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());

            int answer = 0;
            for (int a = 1; a <= n; a++) {
                for (int b = a + 1; b < n; b++) {
                    double result = (Math.pow(a, 2) + Math.pow(b, 2) + m) / (a * b);
                    if (result % 1 == 0.0) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
