import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, List<Integer>> graph;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        graph = new HashMap<>();
        for (int i = 1; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int n) {
        visited[n] = true;
        for (int node: graph.get(n)) {
            if (!visited[node]) {
                parents[node] = n;
                dfs(node);
            }
        }
    }
}
