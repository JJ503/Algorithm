import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n;
    static int[] maps;
    static boolean[] visited;
    static List<Integer> answers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            maps[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        System.out.println(answers.size());
        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }

    private static void bfs(int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[target]) {
                answers.add(target);
                return;
            }

            int next = maps[now];
            if (!visited[next]) {
                queue.add(next);
                visited[next] = true;
            }
        }
    }
}
