import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br;
    static int n;
    static boolean[][] isFriend;
    static int[] visited;
    static int answer = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isFriend = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                if (temp[j].equals("Y")) {
                    isFriend[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new int[n];
            bfs(i);
        }
        
        System.out.println(answer);
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now] == 3) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (isFriend[now][i] && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = visited[now] + 1;
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }
}
