import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static boolean isDecided = false;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[19][19];
        visited = new boolean[19][19];

        for (int i = 0; i < arr.length; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for (int i = 0; i < arr[0].length && !isDecided; i++) {
            for (int j = 0; j < arr.length && !isDecided; j++) {
                if (!visited[j][i] && arr[j][i] != 0) {
                    for (int d = 0; d < dx.length / 2; d++) {
                        bfs(j, i, d);
                        visited = new boolean[19][19];
                    }
                }
            }
        }

        if (!isDecided) {
            System.out.println(0);
        }
    }

    private static void bfs(int x, int y, int d) {
        int teamColor = arr[x][y];
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = d; i < dx.length; i+=4) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < 19 && 0 <= ny && ny < 19) {
                    if (!visited[nx][ny] && teamColor == arr[nx][ny]) {
                        count++;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if (count == 5) {
            System.out.println(teamColor);
            System.out.printf("%d %d", x + 1, y + 1);
            isDecided = true;
            return;
        }
    }
}
