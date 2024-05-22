import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.*;;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int t, l;
    static int startX, startY, endX, endY;
    static int[][] maps;
    static int[][] visited;
    static int answer;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            answer = Integer.MAX_VALUE;

            l = Integer.parseInt(br.readLine());
            maps = new int[l][l];
            visited = new int[l][l];

            str = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(str.nextToken());
            startY = Integer.parseInt(str.nextToken());
            str = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(str.nextToken());
            endY = Integer.parseInt(str.nextToken());

            bfs();

            System.out.println(answer);
        }
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = (int) now.getX();
            int nowY = (int) now.getY();
            
            if (nowX == endX && nowY == endY) {
                answer = Math.min(answer, visited[nowX][nowY]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < l && 0 <= ny && ny < l) {
                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
