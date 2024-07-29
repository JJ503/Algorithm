import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br;
    static boolean[] isPrime = new boolean[1000];

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        setPrimeNumber();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            boolean status = true;

            for (int a = 2; a < k && status; a++) {
                if (!isPrime[a]) continue;

                for (int b = a; b < k && status; b++) {
                    if (!isPrime[b]) continue;

                    for (int c = b; c < k && status; c++) {
                        if (!isPrime[c]) continue;

                        if (a + b + c == k) {
                            System.out.printf("%d %d %d\n", a, b, c);
                            status = false;
                        }
                    }
                }
            }
        }
    }

    private static void setPrimeNumber() {
        Arrays.fill(isPrime, true);

        for (int i = 2; i < 1000; i++) {
            if (isPrime[i]) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime[i] = false;
                        break;
                    }
                }
            }
        }
    }
}
