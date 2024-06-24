import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, k;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> results = new HashSet<>();

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(results.size());
    }

    static void dfs(int count, String result) {
        if (count == k) {
            results.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, result + cards[i]);
                visited[i] = false;
            }
        }
    }
}
