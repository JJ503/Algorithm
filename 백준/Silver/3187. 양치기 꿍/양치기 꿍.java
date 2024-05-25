import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.lang.model.element.ElementKind;
import javax.naming.ldap.ExtendedRequest;

import java.awt.Point;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int r, c;
    static String[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int wolfcount = 0, sheepCount = 0;

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
                    bfs(i, j);
                }
            }
        }

        System.out.printf("%d %d", sheepCount, wolfcount);
    }

    private static void bfs(int x, int y) {
        int wc = 0, sc = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();

            if (maps[nowX][nowY].equals("v")) {
                wc++;
            }
            if (maps[nowX][nowY].equals("k")) {
                sc++;
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

        if (sc > wc) {
            sheepCount += sc;
        } else {
            wolfcount += wc;
        }
    }
}
