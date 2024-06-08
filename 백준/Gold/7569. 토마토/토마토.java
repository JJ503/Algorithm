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
    static int m, n, h;
    static int[][][] maps;
    static int[][][] visited;
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        m = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());
        h = Integer.parseInt(str.nextToken());
        maps = new int[h][n][m];
        visited = new int[h][n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                str = new StringTokenizer(br.readLine());
                Arrays.fill(visited[i][j], -1);

                for (int k = 0; k < m; k++) {
                    maps[i][j][k] = Integer.parseInt(str.nextToken());

                    if (maps[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        visited[i][j][k] = 0;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowH = now[0];
            int nowX = now[1];
            int nowY = now[2];

            for (int i = 0; i < dh.length; i++) {
                int nh = nowH + dh[i];
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nh && nh < h && 0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nh][nx][ny] == 0 && visited[nh][nx][ny] == -1) {
                        queue.add(new int[]{nh, nx, ny});
                        visited[nh][nx][ny] = visited[nowH][nowX][nowY] + 1;
                        maps[nh][nx][ny] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (maps[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    
                    answer = Math.max(answer, visited[i][j][k]);
                }
            }
        }

        System.out.println(answer);
    }
}
