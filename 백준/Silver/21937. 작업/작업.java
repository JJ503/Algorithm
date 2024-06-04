import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m, x;
    static List<Integer>[] maps;
    static boolean[] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            maps[b].add(a);
        }

        x = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer next : maps[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
