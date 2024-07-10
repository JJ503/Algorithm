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
        str = new StringTokenizer(br.readLine());
        
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);
        int num = arr[0];
        int count = 0;
        while (true) {
            count = 0;

            for (int i = 0; i < 5; i++) {
                if (num % arr[i] == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(num);
                break;
            }

            num++;
        }
    }
}
