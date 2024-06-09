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
    static int[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        visited = new int[100_001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                break;
            }

            int[][] moved = {{now * 2, 0}, {now + 1, 1}, {now - 1, 1}};
            for (int[] nextMove : moved) {
                int nextIndex = nextMove[0];
                int addedTime = nextMove[1];

                if (0 <= nextIndex && nextIndex < 100_001 && visited[nextIndex] > visited[now] + addedTime) {
                    queue.add(nextIndex);
                    visited[nextIndex] = visited[now] + addedTime;
                }
            }
        }

        System.out.println(visited[k]);
    }
}
