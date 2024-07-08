import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxNum) {
                count++;
                maxNum = arr[i];
            }
        }
        System.out.println(count);

        count = 0;
        maxNum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > maxNum) {
                count++;
                maxNum = arr[i];
            }
        }
        System.out.println(count);
    }
}
