import java.io.*;
import java.util.*;

public class Main {

    static long a, b;
    static long answer = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        a = Long.parseLong(str.nextToken());
        b = Long.parseLong(str.nextToken());

        dfs(a, 1);

        if (answer == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    public static void dfs(long n, int count) {
        if (n > b) {
            return;
        }
        if (n == b) {
            answer = Math.min(answer, count);
            return;
        }

        dfs(n * 2, count + 1);
        dfs(n * 10 + 1, count + 1);
    }
}
