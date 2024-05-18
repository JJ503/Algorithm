import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int t, h, w, answer;
    static String[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            str = new StringTokenizer(br.readLine());
            h = Integer.parseInt(str.nextToken());
            w = Integer.parseInt(str.nextToken());
            answer = 0;

            setMap();
            countGroup();

            System.out.println(answer);
        }
    }

    private static void setMap() throws IOException {
        maps = new String[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            maps[i] = br.readLine().split("");
        }
    }

    private static void countGroup() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maps[i][j].equals("#") && !visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nowX = (int) point.getX();
            int nowY = (int) point.getY();

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
    
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (maps[nx][ny].equals("#") && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
