import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][2];

        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
            total += arr[i][0];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int minusNum = arr[i][0] + arr[j][0];

                if (total - minusNum == 100) {
                    Arrays.sort(arr, (o1, o2) -> {
                        return o1[0] - o2[0];
                    });

                    for (int num = 0; num < 9; num++) {
                        int idx = arr[num][1];
                        if (idx != i && idx != j) {
                            System.out.println(arr[num][0]);
                        }
                    }

                    return;
                }
            }
        }
    }
}
