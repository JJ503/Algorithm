import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int[] answers, check;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());

        answers = new int[10];
        check = new int[10];
        for (int i = 0; i < 10; i++) {
           answers[i] = Integer.parseInt(str.nextToken());
        }

        bfs(0);

        System.out.println(answer);
    }

    private static void bfs(int depth) {
        if (depth == 10) {
            int count = 0;

            for (int i = 0; i < 10; i++) {
                if (answers[i] == check[i]) {
                    count++;
                }
            }

            if (count >= 5) {
                answer++;
            }

            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (check[depth - 1] == i && check[depth - 2] == i) {
                    continue;
                }
            }

            check[depth] = i;
            bfs(depth + 1);
        }
    }
}
