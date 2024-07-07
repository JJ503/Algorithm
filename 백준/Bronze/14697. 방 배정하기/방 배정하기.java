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

        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());
        int c = Integer.parseInt(str.nextToken());
        int n = Integer.parseInt(str.nextToken());

        for (int i = 1; i < n / a + 1; i++) {
            for (int j = 1; j < n / b + 1; j++) {
                int temp = n;
                temp -= (a * i) + (b * j);

                if (temp % c == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
