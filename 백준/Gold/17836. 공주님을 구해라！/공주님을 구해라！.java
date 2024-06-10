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
    static int n, m, t;
    static int[][] maps;
    static boolean[][] visitedWithoutGram;
    static boolean[][] visitedWithGram;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        t = Integer.parseInt(str.nextToken());
        maps = new int[n][m];
        visitedWithoutGram = new boolean[n][m];
        visitedWithGram = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, false));
        visitedWithoutGram[0][0] = true;
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (now.count > t) {
                break;
            }
            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (now.isExistGram && !visitedWithGram[nx][ny]) {
                        queue.add(new Position(nx, ny, now.count + 1, now.isExistGram));
                        visitedWithGram[nx][ny] = true;
                    } else {
                        if (!visitedWithoutGram[nx][ny]) {
                            if (maps[nx][ny] == 0) {
                                queue.add(new Position(nx, ny, now.count + 1, now.isExistGram));
                                visitedWithoutGram[nx][ny] = true;
                            } else if (maps[nx][ny] == 2) {
                                queue.add(new Position(nx, ny, now.count + 1, true));
                                visitedWithoutGram[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Fail");
    }

    static class Position {
    
        int x;
        int y;
        int count;
        boolean isExistGram;
    
        protected Position(int x, int y, int count, boolean isExistGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isExistGram = isExistGram;
        }

        protected boolean isSamePosition(int x, int y) {
            return this.x == x && this.y == y;
        }
    }
}
