import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int w, h, result;
    static int[][] maps;
    static boolean[][] visited;
    static int[] oddDy = {1, 1, 1, 0, -1, 0};
    static int[] evenDy = {0, 1, 0, -1, -1, -1};
    static int[] dx = {-1, 0, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        w = Integer.parseInt(str.nextToken());
        h = Integer.parseInt(str.nextToken());
        maps = new int[h + 2][w + 2];
        visited = new boolean[h + 2][w + 2];

        for (int i = 1; i <= h; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        result = 0;
        bfs(0, 0);

        System.out.println(result);
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
                int ny = nowY + oddDy[i];
                if (nowX % 2 == 0) {
                    ny = nowY + evenDy[i];
                }

                if (0 <= nx && nx < h + 2 && 0 <= ny && ny < w + 2) {
                    if (maps[nx][ny] == 1) {
                        result++;
                        continue;
                    }
                    if (!visited[nx][ny]) {
                        visited [nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
