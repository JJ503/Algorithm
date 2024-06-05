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
    static int n, m;
    static int[][] maps;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        m = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());
        maps = new int[n][m];
        visited = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], -1);

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());

                if (maps[i][j] == 1) {
                    visited[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
                if (maps[i][j] == -1) {
                    visited[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nx][ny] != -1 && visited[nx][ny] == -1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, visited[i][j]);
            }
        }

        System.out.println(answer);
    }
}
