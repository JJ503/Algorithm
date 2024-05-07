import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k, x;
    static List<Integer>[] maps;
    static int[] distnace;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        x = Integer.parseInt(str.nextToken());
        distnace = new int[n + 1];
        Arrays.fill(distnace, -1);
        maps = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            maps[a].add(b);
        }

        bfs(x);
        printAnswer();
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        distnace[i] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer next : maps[now]) {
                if (distnace[next] == -1) {
                    distnace[next] = distnace[now] + 1;
                    queue.add(next);
                }
            }
        }
    }

    private static void printAnswer() {
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (distnace[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }
}
