import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m, answer;
    static int[][] maps, visited, selectVirus;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());

                if (maps[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        selectVirus = new int[m][2];
        infectionVirus(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    private static void infectionVirus(int count, int start) {
        if (count == m) {
            int countDay = bfs();
            answer = Math.min(answer, countDay);
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            selectVirus[count] = virus.get(i);
            infectionVirus(count + 1, i + 1);
        }
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < m; i++) {
            int[] now = selectVirus[i];
            queue.add(now);
            visited[now[0]][now[1]] = 0;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (maps[nx][ny] != 1 && visited[nx][ny] == -1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[nowX][nowY] + 1;
                    }
                }
            }
        }

        if (checkNonVirus()) {
            return Integer.MAX_VALUE;
        }

        int countDay = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                countDay = Math.max(countDay, visited[i][j]);
            }
        }

        return countDay;
    }

    private static boolean checkNonVirus() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] != 1 && visited[i][j] == -1) {
                    return true;
                }
            }
        }

        return false;
    }
}
