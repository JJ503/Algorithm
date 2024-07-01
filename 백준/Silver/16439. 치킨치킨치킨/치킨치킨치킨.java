import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m, answer = 0;
    static int[][] arr;
    static int[] chicken;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        arr = new int[n][m];
        chicken = new int[3];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int count, int start) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += getMax(i);
            }

            answer = Math.max(answer, sum);
            return;
        }

        for (int i = start; i < m; i++) {
            chicken[count] = i;
            dfs(count + 1, i + 1);
        }
    }

    private static int getMax(int idx) {
        int max = 0;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, arr[idx][chicken[i]]);
        }

        return max;
    }
}
