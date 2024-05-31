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
    static int f, s, g, u, d;
    static int[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        f = Integer.parseInt(str.nextToken());
        s = Integer.parseInt(str.nextToken());
        g = Integer.parseInt(str.nextToken());
        u = Integer.parseInt(str.nextToken());
        d = Integer.parseInt(str.nextToken());
        visited = new int[f + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == g) {
                break;
            }

            int[] nextFloors = {now + u, now - d};
            for (int next : nextFloors) {
                if (0 < next && next <= f && visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }

        if (visited[g] == -1) {
            System.out.println("use the stairs");
            return;
        }

        System.out.println(visited[g]);
    }
}
