import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static boolean[] check = new boolean[1002];

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(str.nextToken());
            check[num] = true;
        }

        int answer = Integer.MAX_VALUE;
        for (int x = 1; x < 1002; x++) {
            if (check[x]) continue;

            for (int y = x; y < 1002; y++) {
                if (check[y]) continue;

                for (int z = y; z < 1002; z++) {
                    if (check[z]) continue;
                    
                    answer = Math.min(answer, Math.abs(n - (x * y * z)));
                }
            }
        }

        System.out.println(answer);
    }
}
