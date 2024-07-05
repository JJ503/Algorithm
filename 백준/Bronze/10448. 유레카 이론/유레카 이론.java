import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static int[] arr;
    static int maxSize = 50;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[maxSize];
        for (int n = 1; n < maxSize; n++) {
            arr[n] = n * (n + 1) / 2;
        }


        int t = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < t; idx++) {
            int k = Integer.parseInt(br.readLine());

            if (checkEureka(k)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean checkEureka(int k) {
        for (int a = 1; a < maxSize; a++) {
            for (int b = 1; b < maxSize; b++) {
                for (int c = 1; c < maxSize; c++) {
                    if (arr[a] + arr[b] + arr[c] == k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
