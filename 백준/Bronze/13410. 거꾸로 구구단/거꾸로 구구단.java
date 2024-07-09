import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        int answer = 0;
        for (int i = 1; i <= k; i++) {
            int temp = n * i;
            StringBuffer sb = new StringBuffer(String.valueOf(n * i));
            temp = Integer.parseInt(sb.reverse().toString());
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
