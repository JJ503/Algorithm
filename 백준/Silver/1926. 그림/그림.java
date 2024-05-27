import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int count = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    int temp = bfs(i, j);
                    maxSize = Math.max(maxSize, temp);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int bfs(int x, int y) {
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
