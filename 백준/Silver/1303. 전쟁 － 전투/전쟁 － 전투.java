import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    static int n, m, whitePower, bluePower;
    static String[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new String[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                maps[i][j] = row[j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int count = bfs(i, j);
                    int power = count * count;
                    if (maps[i][j].equals("W")) {
                        whitePower += power;
                    } else {
                        bluePower += power;
                    }
                }
            }
        }

        System.out.printf("%d %d\n", whitePower, bluePower);
    }

    private static int bfs(int i, int j) {
        int count = 1;
        visited[i][j] = true;

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(i, j));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = (int) p.getX();
            int y = (int) p.getY();

            for (int c = 0; c < 4; c++) {
                int nx = x + dx[c];
                int ny = y + dy[c];

                if (0 <= nx & nx < m & 0 <= ny & ny < n) {
                    if (!visited[nx][ny] & maps[nx][ny].equals(maps[x][y])) {
                        visited[nx][ny] = true;
                        count++;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        return count;
    }
}
