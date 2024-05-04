import java.io.*;
import java.util.*;
import java.awt.*;;

public class Main {

    static int n, m;
    static int[][] maps, answer;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            Arrays.fill(answer[i], -1);

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
                if (maps[i][j] == 2) {
                    queue.add(new Point(i, j));
                    answer[i][j] = 0;
                    visited[i][j] = true;
                }
                if (maps[i][j] == 0) {
                    answer[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = (int) point.getX();
            int y = (int) point.getY();
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nx][ny] != 0 && !visited[nx][ny]) {
                        answer[nx][ny] = answer[x][y] + 1;
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
