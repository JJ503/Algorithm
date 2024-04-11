import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {{
            StringTokenizer str = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(str.nextToken());
            p[i] = Integer.parseInt(str.nextToken());
        }}

        for (int i = n - 1; i > -1; i--) {
            if (i + t[i] > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n]);
	}
}
