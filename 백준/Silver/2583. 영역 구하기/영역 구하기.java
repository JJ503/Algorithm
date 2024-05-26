import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int m, n, k;
    static boolean[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> answers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        m = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        maps = new boolean[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            int minY = Math.min(x1, x2);
            int maxY = Math.max(x1, x2);
            int minX = Math.min(y1, y2);
            int maxX = Math.max(y1, y2);

            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
                    maps[x][y] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!maps[i][j] && !visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        answers.sort(Comparator.naturalOrder());
        String answersStr = answers.toString().replaceAll("[^0-9 ]", "");
        System.out.println(answer);
        System.out.println(answersStr);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (!maps[nx][ny] && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        answers.add(count);
    }
}
