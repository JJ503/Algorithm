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
    static int n, r1, c1, r2, c2;
    static int[][] visited;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        str = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(str.nextToken());
        c1 = Integer.parseInt(str.nextToken());
        r2 = Integer.parseInt(str.nextToken());
        c2 = Integer.parseInt(str.nextToken());

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r1, c1));
        visited[r1][c1] = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = (int) now.getX();
            int y = (int) now.getY();

            if (x == r2 && y == c2) {
                break;
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (visited[nx][ny] == -1) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                } 
            }
        }

        System.out.println(visited[r2][c2]);
    }
}
