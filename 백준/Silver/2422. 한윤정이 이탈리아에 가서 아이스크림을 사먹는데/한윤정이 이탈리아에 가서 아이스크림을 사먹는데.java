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
        boolean[][] avoidPairs = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            avoidPairs[u][v] = true;
            avoidPairs[v][u] = true;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (avoidPairs[i][j] || avoidPairs[j][k] || avoidPairs[k][i]) {
                        continue;
                    }
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
