import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        int answer = 0, temp = 2;
        for (int i = 0; i < n - 2; i++) {
            if (isZigZag(arr[i], arr[i + 1], arr[i + 2])) {
                temp++;
            } else {
                temp = 2;
            }

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }

    private static boolean isZigZag(int a1, int a2, int a3) {
        if (a1 <= a2 && a2 <= a3) {
            return false;
        }
        if (a1 >= a2 && a2 >= a3) {
            return false;
        }

        return true;
    }
}
