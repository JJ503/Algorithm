import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int r, c, sheepCount, wolfCount;
    static int totalSheep = 0, totalWolf = 0;
    static String[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        r = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());
        maps = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            maps[i] = br.readLine().split("");
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!maps[i][j].equals("#") && !visited[i][j]) {
                    sheepCount = 0;
                    wolfCount = 0;

                    bfs(i, j);

                    if (sheepCount > wolfCount) {
                        totalSheep += sheepCount;
                    }
                    if (sheepCount <= wolfCount) {
                        totalWolf += wolfCount;
                    }
                }
            }
        }

        System.out.printf("%d %d", totalSheep, totalWolf);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();

            if (maps[nowX][nowY].equals("o")) {
                sheepCount++;
            }
            if (maps[nowX][nowY].equals("v")) {
                wolfCount++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                    if (!maps[nx][ny].equals("#") && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
