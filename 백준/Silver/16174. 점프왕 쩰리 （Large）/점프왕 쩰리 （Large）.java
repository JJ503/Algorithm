import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n;
    static int[][] maps;
    static int[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int cnt = maps[nowX][nowY];

            if (maps[nowX][nowY] == -1) {
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + (cnt * dx[i]);
                int ny = nowY + (cnt * dy[i]);

                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == -1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[nowX][nowY] + 1;
                }
            }
        }

        if (visited[n - 1][n - 1] == -1) {
            System.out.println("Hing");
            return;
        }

        System.out.println("HaruHaru");
    }
}
