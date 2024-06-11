import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, m;
    static List<Integer>[] maps;
    static boolean[] visited;
    static boolean status = false;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        visited = new boolean[n];

        maps = new List[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            maps[a].add(b);
            maps[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            if (status) {
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }

        System.out.println(0);
    }
    
    private static void dfs(int idx, int depth) {
        if (depth == 5) {
            status = true;
            return;
        }

        for (int next : maps[idx]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}
