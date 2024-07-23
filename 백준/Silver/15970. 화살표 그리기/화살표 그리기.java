import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int WHITE = 1, BLACK = 2;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] whiteArr = new boolean[100001];
        boolean[] blackArr = new boolean[100001];

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());

            if (y == WHITE) {
                whiteArr[x] = true;
                continue;
            }
            blackArr[x] = true;
        }

        int whiteLength = countLenght(whiteArr);
        int blackLength = countLenght(blackArr);

        System.out.println(whiteLength + blackLength);
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
