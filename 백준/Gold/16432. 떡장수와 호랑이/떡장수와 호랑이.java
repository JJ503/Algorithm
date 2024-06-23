import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static int[][] maps;
    static boolean[][] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n][9];
        visited = new boolean[n + 1][9];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            m = Integer.parseInt(str.nextToken());

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        dfs(0, 0);
        for (int a : answer) {
            if (a == 0) {
                System.out.println(-1);
                return;
            }
        }
    }

    static void dfs(int day, int beforeM) {
        if (day == n) {
            for (int i = 0; i < n; i++) {
                System.out.println(answer[i]);
            }
            System.exit(0);
        }

        for (int m : maps[day]) {
            if (m != 0 && m != beforeM && !visited[day][m - 1]) {
                visited[day][m - 1] = true;
                answer[day] = m;
                dfs(day + 1, m);
            }
        }
    }
}
