import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static int[][] maps;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int answer = 0;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, visited[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();

            for (int i = 0; i < 8; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (visited[nx][ny] > visited[nowX][nowY] + 1 && maps[nx][ny] == 0) {
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
