import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, k;
    static boolean[] visited = new boolean[100001];
    static int[] time, parent;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        visited[n] = true;
        Deque<Integer> temp = new ArrayDeque<>();
        temp.add(n);
        bfs();

        System.out.println(time[k]);
        int now = k;
        StringBuilder sb = new StringBuilder();
        while (now != n) {
            sb.insert(0, now + " ");
            now = parent[now];
        }
        sb.insert(0, n + " ");
        System.out.println(sb.toString());
    }

    static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        time = new int[100_001];
        parent = new int[100_001];
        Arrays.fill(time, -1);
        queue.add(n);
        time[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                return;
            }

            int[] nexts = {now * 2, now + 1, now - 1};
            for (int next : nexts) {
                if (0 <= next && next < 100_001 && time[next] == -1) {
                    time[next] = time[now] + 1;
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
    }
}
