import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, line;
    static boolean[] visited;
    static int[][] array;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            array[a][b] = array[b][a] = 1;
        }

        dfs(1);

        System.out.println(answer - 1);
    }

    public static void dfs(int start) {
        visited[start] = true;
        answer++;

        for (int i = 1; i <= n; i++) {
            if (array[start][i] == 1 & !visited[i]) {
                dfs(i);
            }
        }
    }
}
