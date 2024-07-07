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

        if (n % a == 0 || n % b == 0 || n % c == 0) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i <= n; i++) {
            int aStudent = a * i;
            for (int j = 0; j <= n; j++) {
                int bStudent = b * j;
                for (int k = 0; k <= n; k++) {
                    int cStudent = c * k;
                    
                    if (aStudent + bStudent + cStudent == n) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}
