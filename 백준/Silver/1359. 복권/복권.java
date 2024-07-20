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

        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        double result = 0.0;
        double totalCombination = combination(n, m);

        while (m >= k) {
            if (n - m < m - k) {
                k++;
                continue;
            }

            double c = combination(m, k) * combination(n - m, m - k);

            result += c / totalCombination;
            k++;
        }

        System.out.println(result);
    }

    private static double combination(int n, int r) {
        int a = 1;
        int d = 1;

        while (r > 0) {
            a *= n--;
            d *= r--;
        }

        return a / d;
    }
}
