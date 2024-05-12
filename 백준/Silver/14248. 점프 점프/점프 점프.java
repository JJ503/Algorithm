import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, s;
    static int[] maps;
    static boolean[] visited;
    static int answer = 0;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n + 1];
        visited = new boolean[n + 1];

        str = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            maps[i] = Integer.parseInt(str.nextToken());
        }

        s = Integer.parseInt(br.readLine());

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        answer++;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            int moved = maps[now];

            int next1 = now + moved;
            int next2 = now - moved;
            if (next1 <= n && !visited[next1]) {
                queue.add(next1);
                visited[next1] = true;
                answer++;
            }
            if (next2 >= 1 && !visited[next2]) {
                queue.add(next2);
                visited[next2] = true;
                answer++;
            }
        }
    }
}
