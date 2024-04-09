import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, start, target;
    static int[][] array;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        answer = n + 1;

        StringTokenizer str = new StringTokenizer(br.readLine());
        start = Integer.parseInt(str.nextToken());
        target = Integer.parseInt(str.nextToken());
        int row = Integer.parseInt(br.readLine());

        for (int i = 0; i < row; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());

            array[x][y] = array[y][x] = 1;
        }

        dfs(start, 0);

        if (answer == (n + 1)) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    public static void dfs(int idx, int count) {
        visited[idx] = true;

        if (idx == target) {
            answer = Math.min(answer, count);
        }

        for (int i = 1; i <= n; i++) {
            if (array[idx][i] == 1 & !visited[i]) {
                dfs(i, count + 1);
            }
        }
    }
}
