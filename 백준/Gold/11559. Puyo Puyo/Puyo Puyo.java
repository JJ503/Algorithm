import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br;
    static char[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        maps = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        boolean status = true;
        int answer = -1;
        while (status) {
            visited = new boolean[12][6];
            status = checkPuyo();
            setMaps();
            answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkPuyo() {
        boolean status = false;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (maps[i][j] != '.' && !visited[i][j]) {
                    if (bfs(i, j)) {
                        status = true;
                    }
                }
            }
        }

        return status;
    }

    private static boolean bfs(int x, int y) {
        ArrayList<int[]> stack = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        stack.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            char nowColor = maps[nowX][nowY];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < 12 && 0 <= ny && ny < 6) {
                    if (maps[nx][ny] == nowColor && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        stack.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if (stack.size() >= 4) {
            for (int i = 0; i < stack.size(); i++) {
                int nowX = stack.get(i)[0];
                int nowY = stack.get(i)[1];
                maps[nowX][nowY] = '.';
            }

            return true;
        }

        return false;
    }

    private static void setMaps() {

        for (int i = 0; i < 6; i++) {
            Queue<Character> queue = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (maps[j][i] != '.') {
                    queue.add(maps[j][i]);
                    maps[j][i] = '.';
                }
            }

            int idx = 11;
            while (!queue.isEmpty()) {
                maps[idx][i] = queue.poll();
                idx--;
            }
        }
    }
}
