import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int t, w, h;
    static char[][] maps;
    static char blank = '.', start = '@', fire = '*';
    static int[][] visited;
    static Queue<int[]> queue;
    static Queue<int[]> fireQueue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            queue = new LinkedList<>();
            fireQueue = new LinkedList<>();
            setMap();
            String answer = escape();

            System.out.println(answer);
        }
    }

    private static void setMap() throws IOException {
        str = new StringTokenizer(br.readLine());
        w = Integer.parseInt(str.nextToken());
        h = Integer.parseInt(str.nextToken());
        maps = new char[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            String row = br.readLine();
            for (int j = 0; j < w; j++) {
                maps[i][j] = row.charAt(j);

                if (maps[i][j] == start) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    maps[i][j] = blank;
                }
                if (maps[i][j] == fire) {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }
    }

    private static String escape() {
        while (!queue.isEmpty()) {
            movedFire();
            
            int nowQueueSize = queue.size();
            for (int cnt = 0; cnt < nowQueueSize; cnt++) {
                int[] now = queue.poll();
                int nowX = now[0];
                int nowY = now[1];

                if (isEscape(nowX, nowY)) {
                    return String.valueOf(visited[nowX][nowY]);
                }

                for (int i = 0; i < dx.length; i++) {
                    int nx = nowX + dx[i];
                    int ny = nowY + dy[i];

                    if (innerMaps(nx, ny)) {
                        if (maps[nx][ny] == blank && visited[nx][ny] == 0) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = visited[nowX][nowY] + 1;
                        }
                    }
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private static void movedFire() {
        int fireQueueSize = fireQueue.size();
        for (int cnt = 0; cnt < fireQueueSize; cnt++) {
            int[] now = fireQueue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (innerMaps(nx, ny) && maps[nx][ny] == blank) {
                    maps[nx][ny] = fire;
                    fireQueue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean innerMaps(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
    }

    private static boolean isEscape(int x, int y) {
        return x == 0 || x == (h - 1) || y == 0 || y == (w - 1);
    }
}
