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
    static int[] maps;
    static int[] visited;
    static int[] dx = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new int[101];
        visited = new int[101];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            maps[x] = y;
        }
        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            maps[u] = v;
        }

        bfs(1);
        System.out.println(visited[100]);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == 100) {
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = now + dx[i];

                if (nx <= 100) {
                    if (maps[nx] != 0) {
                        nx = maps[nx];
                    }

                    if (visited[nx] == -1) {
                        queue.add(nx);
                        visited[nx] = visited[now] + 1;
                    }
                }
            }
        }
    }
}
