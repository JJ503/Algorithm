import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, k;
    static Integer[][] maps;
    static int safeZone = 1;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        maps = new Integer[2][n];
        maps[0] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        maps[1] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        visited = new boolean[2][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowLine = now[0];
            int nowRow = now[1];
            int nowTime = now[2];

            if (nowRow >= n) {
                System.out.println(1);
                return;
            }

            int[][] nexts = {{nowLine, nowRow + 1}, {nowLine, nowRow - 1}, {Math.abs(nowLine - 1), nowRow + k}};
            for (int[] next : nexts) {
                int nextLine = next[0];
                int nextRow = next[1];

                if (nextRow > nowTime && nextRow < n && maps[nextLine][nextRow] == safeZone && !visited[nextLine][nextRow]) {
                    queue.add(new int[]{nextLine, nextRow, nowTime + 1});
                    visited[nextLine][nextRow] = true;
                }
                if (nextRow >= n) {
                    queue.add(new int[]{nextLine, nextRow, nowTime + 1});
                }
            }
        }

        System.out.println(0);
    }
}
