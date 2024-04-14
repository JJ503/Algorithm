import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int[] files, sum;
    static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            files = new int[k + 1];
            sum = new int[k + 1];
            dp = new int[k + 1][k + 1];

            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 1; j <= k; j++) {
                files[j] = Integer.parseInt(str.nextToken());
                sum[j] = sum[j - 1] + files[j];
            }
            
            System.out.println(getAnswer());
        }
    }

    public static int getAnswer() {
        // 몇 개의 파일을 묶을 것인가?
        for (int n = 1; n <= k; n++) {
            // 몇 번째 파일부터 시작할 것인가
            for (int from = 1; from <= k - n; from++) {
                int to = from + n;
                dp[from][to] = Integer.MAX_VALUE;
                // 몇 번째 파일을 기준으로 묶을 것인가
                for (int d = from; d < to; d++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][d] + dp[d + 1][to] + sum[to] - sum[from - 1]);
                }
            }
        }

        return dp[1][k];
    }
}
