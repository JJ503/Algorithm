import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static String[][] maps;
    static String land = "L";
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new String[n][m];

        for (int i = 0; i < n; i++) {
            maps[i] = br.readLine().split("");
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j].equals(land)) {
                    visited = new boolean[n][m];
                    int count = bfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        int maxCount = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCount = now[2];

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                int nCount = nowCount + 1;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nx][ny].equals(land) && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny, nCount});
                        visited[nx][ny] = true;
                        maxCount = Math.max(maxCount, nCount);
                    }
                }
            }
        }

        return maxCount;
    }
}
