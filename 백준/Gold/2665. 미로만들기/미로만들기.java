import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n;
    static int[][] maps, visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for (int j = 0; j < n; j++) {
                maps[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        bfs();

        System.out.println(visited[n - 1][n - 1]);
    }

    static void bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (maps[nx][ny] == 0 && visited[nx][ny] > visited[nowX][nowY] + 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                    } else if (maps[nx][ny] == 1 && visited[nx][ny] > visited[nowX][nowY]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[nowX][nowY];
                    }
                }
            }
        }
    }
}
