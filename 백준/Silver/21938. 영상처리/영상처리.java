import java.io.*;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m, t;
    static int[][] colors;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        colors = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int temp = 0;
                for (int l = 0; l < 3; l++) {
                    temp += Integer.parseInt(str.nextToken());
                }
                colors[i][j] = (temp / 3);
            }
        }
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (colors[i][j] >= t && !visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
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
                    if (colors[nx][ny] >= t && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
