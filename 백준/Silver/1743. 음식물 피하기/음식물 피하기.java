import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] maps, visited;
    static int maxCount, count = 0;
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        maps = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken()) - 1;
            int y = Integer.parseInt(str.nextToken()) - 1;
            maps[x][y] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] & !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        System.out.println(maxCount);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx & nx < n & 0 <= ny & ny < m) {
                if (maps[nx][ny] & !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
