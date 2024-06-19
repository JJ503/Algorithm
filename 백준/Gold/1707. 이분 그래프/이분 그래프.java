import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int k;
    static ArrayList<Integer>[] maps;
    static int[] visited;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        for (int t = 0; t < k; t++) {
            str = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(str.nextToken());
            int E = Integer.parseInt(str.nextToken());
            maps = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                maps[i] = new ArrayList<>();
            }
            visited = new int[V + 1];

            for (int i = 0; i < E; i++) {
                str = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(str.nextToken());
                int u = Integer.parseInt(str.nextToken());
                maps[v].add(u);
                maps[u].add(v);
            }

            boolean status = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    if (!bfs(i)) {
                        status = false;
                        break;
                    }
                }
            }

            if (status) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowColor = visited[now];

            for (int next : maps[now]) {
                if (visited[next] != 0 && visited[next] == nowColor) {
                    return false;
                }

                if (visited[next] == 0) {
                    queue.add(next);
                    if (nowColor == 1) {
                        visited[next] = -1;
                    } else {
                        visited[next] = 1;
                    }
                }
            }
        }

        return true;
    }
}
