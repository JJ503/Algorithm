import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());

        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        arr = new int[n];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > i * k) {
                int count = getCount(i);
                answer = Math.min(answer, count);
            }
        }

        System.out.println(answer);
    }

    private static int getCount(int idx) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i < idx) {
                if (arr[i] != (arr[idx] - (idx - i) * k)) {
                    count++;
                }
            } else if (i > idx) {
                if (arr[i] != (arr[idx] + (i - idx) * k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
