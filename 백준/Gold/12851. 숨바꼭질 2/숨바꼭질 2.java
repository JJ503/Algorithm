import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] time = new int[1000001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs(n);
        System.out.println(minTime + "\n" + count);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 1;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < time[now]) {
                return;
            }

            int[] nextArray = {now - 1, now + 1, now * 2};
            for (int next: nextArray) {
                if (next < 0 || next > 100_000) {
                    continue;
                }
                if (next == k) {
                    minTime = time[now];
                    count++;
                }
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
