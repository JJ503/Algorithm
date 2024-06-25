import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int a, b, c, d, e, f;
    static String[] cards;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());
        d = Integer.parseInt(str.nextToken());
        e = Integer.parseInt(str.nextToken());
        f = Integer.parseInt(str.nextToken());

        boolean status = false;
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                int formula1 = (a * i) + (b * j);
                int formula2 = (d * i) + (e * j);

                if (formula1 == c && formula2 == f) {
                    System.out.printf("%d %d", i, j);
                    status = true;
                    break;
                }
            }

            if (status) {
                break;
            }
        }
    }
}
