import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        boolean[] check = new boolean[1_000_001];
        for (int i = 0; i < n; i++) {
            if (!check[arr[i]]) {
                int count = getMaxContinuity(arr, arr[i]);
                answer = Math.max(answer, count);
                check[arr[i]] = true;
            }
        }

        System.out.println(answer);
    }

    private static int getMaxContinuity(int[] arr, int excludeNumber) {
        int count = 1, answer = 1;

        int beforeNumber = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == excludeNumber) {
                continue;
            }
            if (arr[i] == beforeNumber) {
                count++;
                answer = Math.max(answer, count);
            } else {
                count = 1;
            }

            beforeNumber = arr[i];
        }

        return answer;
    }
}
