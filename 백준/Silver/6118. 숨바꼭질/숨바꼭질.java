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
    static int n, m;
    static List<Integer>[] maps;
    static int[] counts;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        maps = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            maps[i] = new ArrayList<>();
        }

        counts = new int[n + 1];
        Arrays.fill(counts, -1);

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            maps[a].add(b);
            maps[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        counts[1] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer next : maps[now]) {
                if (counts[next] == -1) {
                    counts[next] = counts[now] + 1;
                    queue.add(next);
                }
            }
        }

        int minIndex = n + 2;
        int distance = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance < counts[i]) {
                minIndex = i;
                distance = counts[i];
                count = 1;
                continue;
            }
            if (distance == counts[i]) {
                minIndex = Math.min(minIndex, i);
                count++;
            }
        }

        System.out.printf("%d %d %d", minIndex, distance, count);
    }
}
