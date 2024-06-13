import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int w, h;
    static int time = 0, lastPieces = 0, totalCheese = 0;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        h = Integer.parseInt(str.nextToken());
        w = Integer.parseInt(str.nextToken());
        maps = new int[h][w];

        for (int i = 0; i < h; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());

                if (maps[i][j] == 1) {
                    totalCheese++;
                }
            }
        }

        while (totalCheese > 0) {
            visited = new boolean[h][w];
            lastPieces = totalCheese;
            time++;
            bfs(0, 0);
        }

        System.out.printf("%d\n%d", time, lastPieces);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (maps[nx][ny] == 1) {
                        totalCheese--;
                        maps[nx][ny] = 0;
                    } else if (maps[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
