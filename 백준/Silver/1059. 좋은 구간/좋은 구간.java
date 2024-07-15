import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int l, n;
    static int[] s;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());

        s = new int[l];
        str = new StringTokenizer(br.readLine());
        int maxNumber = 0;
        for (int i = 0; i < l; i++) {
            s[i] = Integer.parseInt(str.nextToken());
            maxNumber = Math.max(maxNumber, s[i]);
        }
        n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int a = 1; a < maxNumber; a++) {
            for (int b = a + 1; b < maxNumber; b++) {
                if (isValidSection(a, b)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isValidSection(int a, int b) {
        if (a >= b) {
            return false;
        }
        for (int number : s) {
            if (a <= number && number <= b) {
                return false;
            }
        }

        return a <= n && n <= b;
    }
}
