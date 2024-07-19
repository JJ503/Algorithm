import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

        String temp = "";
        while ((temp = br.readLine()) != null) {
            str = new StringTokenizer(temp);
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());

            System.out.println(countValidRoom(n, m));
        }
    }

    private static int countValidRoom(int n, int m) {
        int count = 0;

        for (int i = n; i <= m; i++) {
            if (isValidRoom(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isValidRoom(int number) {
        check = new boolean[10];

        while (number != 0) {
            int checkNumber = number % 10;

            if (check[checkNumber]) {
                return false;
            }

            check[checkNumber] = true;
            number /= 10;
        }

        return true;
    }
}
