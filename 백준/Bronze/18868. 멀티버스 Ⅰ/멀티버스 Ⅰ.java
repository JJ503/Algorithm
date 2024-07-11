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

        int m = Integer.parseInt(str.nextToken());
        int n = Integer.parseInt(str.nextToken());

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int answer = 0;
        for (int a = 0; a < m; a++) {
            for (int b = a + 1; b < m; b++) {
                if (isValidUniverse(arr[a], arr[b])) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isValidUniverse(int[] u1, int[] u2) {
        int n = u1.length;
        int validCount = n * (n - 1) / 2;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isMeetCondition(u1[i], u1[j], u2[i], u2[j])) {
                    count++;
                }
            }
        }

        if (count == validCount) {
            return true;
        }

        return false;
    }

    private static boolean isMeetCondition(int a1, int a2, int b1, int b2) {
        if (a1 > a2 && b1 > b2) {
            return true;
        }
        if (a1 == a2 && b1 == b2) {
            return true;
        }
        if (a1 < a2 && b1 < b2) {
            return true;
        }

        return false;
    }
}
