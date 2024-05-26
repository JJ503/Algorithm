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
    static int n, k;
    static int[] visited = new int[100_001];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                break;
            }

            int[] array = {now -1, now + 1, now * 2};
            for (int next : array) {
                if (0 <= next && next <= 100_000 && visited[next] == -1) {
                    queue.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }

        System.out.println(visited[k]);
    }
}
