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
    static int[][] arr;
    static int[][][] visited;
    static int[] dx = {-1, 0, 1};
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        visited = new int[n][m][dx.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < m; i++) {
            queue.add(new Position(i, 0));
            Arrays.fill(visited[0][i], arr[0][i]);
        }

        bfs();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < dx.length; j++) {
                answer = Math.min(answer, visited[n - 1][i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.getX();
            int y = position.getY();
            int beforeMove = position.getBeforeMove();

            for (int i = 0; i < dx.length; i++) {
                if (i == beforeMove) {
                    continue;
                }

                int nx = x + dx[i];
                int ny = y + 1;
                
                if (beforeMove == -1) {
                    beforeMove = 0;
                }
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    int needFeul = visited[y][x][beforeMove] + arr[ny][nx];
                    if (needFeul <= visited[ny][nx][i]) {
                        visited[ny][nx][i] = needFeul;
                        queue.add(new Position(nx, ny, i));
                    }
                }
            }
        }
    }
}

class Position {

    private int x;
    private int y;
    private int beforeMove;

    public Position(int x, int y, int beforeMove) {
        this.x = x;
        this.y = y;
        this.beforeMove = beforeMove;
    }

    public Position(int x, int y) {
        this(x, y, -1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBeforeMove() {
        return beforeMove;
    }
}
