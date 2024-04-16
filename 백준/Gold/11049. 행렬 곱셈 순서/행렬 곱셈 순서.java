import java.io.*;
import java.util.*;

public class Main {

    static int[][] array, dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        array = new int[n][2];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(str.nextToken());
            array[i][1] = Integer.parseInt(str.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][i + j] = Integer.MAX_VALUE;
                for (int k = j; k < i + j; k++) {
                    dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + array[j][0] * array[k][1] * array[i + j][1]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
