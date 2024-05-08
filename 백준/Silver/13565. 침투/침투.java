import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.*;;

public class Main {

    static int n, m;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        m = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());
        maps = new int[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (maps[0][i] == 0) {
                dfs(0, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (maps[m - 1][i] == -1) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        maps[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                if (maps[nx][ny] == 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
