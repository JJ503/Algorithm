import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n;
    static int[] sArr, bArr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sArr = new int[n];
        bArr = new int[n];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            sArr[i] = Integer.parseInt(str.nextToken());
            bArr[i] = Integer.parseInt(str.nextToken());
        }

        dfs(1, 0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int s, int b, int count, int selectFlavorCount) {
        if (count == n ) {
            if (selectFlavorCount != 0) {
                answer = Math.min(answer, Math.abs(s - b));
            }

            return;
        }

        dfs(s * sArr[count], b + bArr[count], count + 1, selectFlavorCount + 1);
        dfs(s, b, count + 1, selectFlavorCount);
    }
}
