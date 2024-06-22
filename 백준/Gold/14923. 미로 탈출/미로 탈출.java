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
    static int n, m, Hx, Hy, Ex, Ey;
    static int[][] maps;
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(str.nextToken()) - 1;
        Hy = Integer.parseInt(str.nextToken()) - 1;
        str = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(str.nextToken()) - 1;
        Ey = Integer.parseInt(str.nextToken()) - 1;
        maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }

        System.out.println(bfs());
    }
        
    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Hx, Hy, 0});
        visited[Hx][Hy][0] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int isMagic = now[2];

            if (nowX == Ex && nowY == Ey) {
                return visited[nowX][nowY][isMagic];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny][isMagic] == -1) {
                    if (maps[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny, isMagic});
                        visited[nx][ny][isMagic] = visited[nowX][nowY][isMagic] + 1;
                    }
                    if (maps[nx][ny] == 1 && isMagic == 0) {
                        queue.add(new int[]{nx, ny, 1});
                        visited[nx][ny][1] = visited[nowX][nowY][isMagic] + 1;
                    }
                }
            }
        }

        return -1;
    }
}
