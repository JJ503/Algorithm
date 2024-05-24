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
    static int a, b, n, m;
    static int[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, -1);

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int[] d = {now + 1, now - 1, now + a, now - a, now * a, -now * a, now + b, now - b, now * b, -now * b};
            for (int next : d) {
                if (0 <= next && next < 100001 && visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);

                    if (next == m) {
                        return visited[next];
                    }
                }
            }
        }

        return -1;
    }
}
