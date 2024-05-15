import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int a, b, n, m;
    static List<Integer>[] maps;
    static int[] visited;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new List[n + 1];
        visited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            maps[i] = new ArrayList<>();
            visited[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(str.nextToken());
            int n2 = Integer.parseInt(str.nextToken());
            maps[n1].add(n2);
            maps[n2].add(n1);
        }

        bfs();

        if (visited[b] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(visited[b]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer next : maps[now]) {
                if (visited[next] > visited[now] + 1) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
