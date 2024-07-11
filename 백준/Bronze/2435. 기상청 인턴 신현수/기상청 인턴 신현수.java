import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        int[] arr = new int[n];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;

            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
