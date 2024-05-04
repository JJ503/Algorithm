import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            m = Integer.parseInt(str.nextToken());
            n = Integer.parseInt(str.nextToken());
            k = Integer.parseInt(str.nextToken());
            maps = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                Arrays.fill(maps[i], 0);
            }

            for (int i = 0; i < k; i++) {
                str = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(str.nextToken());
                int x = Integer.parseInt(str.nextToken());
                maps[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (maps[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
