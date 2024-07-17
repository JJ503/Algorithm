import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int h, y, answer = 0;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        h = Integer.parseInt(str.nextToken());
        y = Integer.parseInt(str.nextToken());

        dfs(h, 0);

        System.out.println(answer);
    }

    private static void dfs(int nowExpense, int nowYear) {
        if (nowYear == y) {
            answer = Math.max(answer, nowExpense);
            return;
        }
        if (nowYear > y) {
            return;
        }

        dfs((int) Math.floor(nowExpense * 1.05), nowYear + 1);
        dfs((int) Math.floor(nowExpense * 1.2), nowYear + 3);
        dfs((int) Math.floor(nowExpense * 1.35), nowYear + 5);
    }
}
