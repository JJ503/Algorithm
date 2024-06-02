import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static int[][] maps;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int BARRIER = 1;
    static int FAMILY = 2;
    static List<Integer> FOODS = List.of(3, 4, 5);

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new int[n][m];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(temp[j]);
                if (maps[i][j] == FAMILY) {
                    start = new int[]{i, j};
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        maps[start[0]][start[1]] = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCount = now[2];

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nx][ny] != BARRIER) {
                        if (FOODS.contains(maps[nx][ny])) {
                            System.out.printf("TAK\n%d", nowCount + 1);
                            return;
                        }

                        queue.add(new int[]{nx, ny, nowCount + 1});
                        maps[nx][ny] = 1;
                    }
                }
            }
        }

        System.out.println("NIE");
    }
}
