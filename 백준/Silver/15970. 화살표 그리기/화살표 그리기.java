import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][100001];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken()) - 1;

            arr[y][x] = true;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += countLenght(arr[i]);
        }

        System.out.println(answer);
    }

    private static int countLenght(boolean[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count += Math.min(countLeft(arr, i), countRight(arr, i));
            }
        }

        return count;
    }

    private static int countLeft(boolean[] arr, int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (arr[i]) {
                return idx - i;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static int countRight(boolean[] arr, int idx) {
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i]) {
                return i - idx;
            }
        }

        return Integer.MAX_VALUE;
    }
}
