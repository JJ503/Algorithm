import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m, startX, startY;
    static int[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        visited = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            Arrays.fill(visited[j], -1);
        }

        str = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(str.nextToken());
        startY = Integer.parseInt(str.nextToken());

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            sb.append(visited[x][y]).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = 0;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 < nx && nx <= n && 0 < ny && ny <= n) {
                    if (visited[nx][ny] == -1) {
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
