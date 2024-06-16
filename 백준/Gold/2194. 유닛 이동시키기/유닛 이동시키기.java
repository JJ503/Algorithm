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
    static int n, m, a, b, k;
    static int[][] maps;
    static int[][] visited;
    static int blank = 0, barrier = 1;
    static int startX, startY, endX, endY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        maps = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        int r, c;
        for (int i = 0; i < k; i++) {
            str = new StringTokenizer(br.readLine());
            r = Integer.parseInt(str.nextToken()) - 1;
            c = Integer.parseInt(str.nextToken()) - 1;
            maps[r][c] = barrier;
        }

        str = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(str.nextToken()) - 1;
        startY = Integer.parseInt(str.nextToken()) - 1;

        str = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(str.nextToken()) - 1;
        endY = Integer.parseInt(str.nextToken()) - 1;

        int answer = bfs(startX, startY);
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = 0;


        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == endX && nowY == endY) {
                return visited[nowX][nowY];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    boolean canMove = true;
                    for (int row = nx; row < nx + a; row++) {
                        for (int col = ny; col < ny + b; col++) {
                            if (0 <= row && row < n && 0 <= col && col < m) {
                                if (maps[row][col] != barrier) {
                                    continue;
                                }
                            }
                            canMove = false;
                        }
                    }
                    if (canMove && visited[nx][ny] == -1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                    }
                }
            }
        }

        return -1;
    }
}
