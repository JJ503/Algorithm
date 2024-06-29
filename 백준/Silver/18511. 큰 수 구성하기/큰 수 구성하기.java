import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, k, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        arr = new int[k];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int now) {
        if (now > n) return;
        answer = Math.max(answer, now);

        for (int i = k - 1; i >= 0; i--) {
            dfs(now * 10 + arr[i]);
        }
    }
}
