import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, List<Integer>> maps = new HashMap<>();
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int firstIndex = Integer.parseInt(str.nextToken());
            int secondIndex = Integer.parseInt(str.nextToken());
            maps.putIfAbsent(firstIndex, new ArrayList<Integer>());
            maps.putIfAbsent(secondIndex, new ArrayList<Integer>());
            maps.get(firstIndex).add(secondIndex);
            maps.get(secondIndex).add(firstIndex);
        }

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        List<Integer> array = maps.get(idx);
        if (array != null) {
            for (Integer nextIdx : array) {
                if (!visited[nextIdx]) {
                    answer++;
                    dfs(nextIdx);
                }
            }
        }
    }
}
